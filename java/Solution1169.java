class Solution {
    public List<String> invalidTransactions(String[] trans) {
        Transaction[] transactions = new Transaction[trans.length];
        for (int i = 0; i < transactions.length; i++) transactions[i] = new Transaction(i, trans[i]);
        Arrays.sort(transactions, (t1, t2) -> t1.time - t2.time);

        List<String> result = new ArrayList();
        Set<Integer> invalidTransactions = new HashSet();

        // key: name, transactins
        HashMap<String, List<Transaction>> map = new HashMap();
        for (int i = 0; i < transactions.length; i++) {            
            Transaction current = transactions[i];
            List<Transaction> transactionByPerson = map.getOrDefault(current.name, new ArrayList());

            if (current.isOverPrice()) invalidTransactions.add(current.id);

            for (int j = transactionByPerson.size() - 1; j >= 0; j--) {
                Transaction prev = transactionByPerson.get(j);
                if (current.time - prev.time > 60) break;
                if (current.location.equals(prev.location)) continue;

                invalidTransactions.add(current.id);
                invalidTransactions.add(prev.id);
            }

            transactionByPerson.add(current);
            map.put(current.name, transactionByPerson);
        }

        for (Integer invalidTransaction : invalidTransactions) result.add(trans[invalidTransaction]);
        return result;
    }

    class Transaction {
        String name;
        int price;
        int time;
        String location;
        int id;

        public Transaction(int id, String tran) {
            this.id = id;
            String[] info = tran.split(",");
            this.name = info[0];
            this.time = Integer.valueOf(info[1]);
            this.price = Integer.valueOf(info[2]);
            this.location = info[3];
        }

        private boolean isOverPrice() {
            return this.price > 1000;
        }

        private int id() {
            return this.id;
        }
    }
}