class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap();
        Map<String, String> emailByName = new HashMap();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                emailByName.put(email, accounts.get(i).get(0));
                if (!parents.containsKey(email)) {
                    // trick -> set the first email as default parent
                    parents.put(email, accounts.get(i).get(1));
                } else {
                     // trick -> join default parent with existing parent if email exists
                    String parent1 = find(parents, email);
                    String parent2 = find(parents, accounts.get(i).get(1));
                    if (parent1 != parent2) union(parents, parent1, parent2);
                }
            }
        }

        Map<String, List<String>> tempResults = new HashMap();
        for (Map.Entry<String, String> parentEntry : parents.entrySet()) {
            String email = parentEntry.getKey();
            String parentEmail = find(parents, email);
            List<String> emails = tempResults.getOrDefault(parentEmail, new ArrayList<String>());
            emails.add(email);
            tempResults.put(parentEmail, emails);
        }

        List<List<String>> results = new ArrayList();
        for (Map.Entry<String, List<String>> parentEntry : tempResults.entrySet()) {
            String name = emailByName.get(parentEntry.getKey());
            List<String> emails = parentEntry.getValue();
            List<String> result = new ArrayList();
            result.add(name);
            Collections.sort(emails);
            for (String email : emails) result.add(email);
            results.add(result);
        }
        return results;
    }

    private void union(Map<String, String> parents, String parent1, String parent2) {
        if (parent1.compareTo(parent2) < 0) {
            parents.put(parent1, parent2);
        } else {
            parents.put(parent2, parent1);
        }
    }

    // trick -> this is very easy to make mistake here
    //          this parts includes path compression
    private String find(Map<String, String> parents, String email) {
        if (email != parents.get(email)) parents.put(email, find(parents, parents.get(email)));
        return parents.get(email);
    }
}
