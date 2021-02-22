class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        String str = replaceString(expression, evalvars, evalints);
        Sequence sequence = process(str, '+', new int[] { 0 });
        List<String> results = sequence.toList();
        return results;
    }

    private Sequence process(String str, char initOp, int[] i) {
        Stack<Sequence> stack = new Stack();
        char op = '+';
        Sequence current = new Sequence(op);
        while (i[0] < str.length()) {
            char c = str.charAt(i[0]);
            if (c == '+') {
                op = '+';
                i[0]++;
            } else if (c == '-' && str.charAt(i[0] + 1) == ' ') {
                op = '-';
                i[0]++;
            } else if (c == '*') {
                op = '*';
                if (i[0] >= 0 && str.charAt(i[0] - 2) == ')' && (i[0] + 2 < str.length()) && str.charAt(i[0] + 2) != '(') {
                    addToStack(stack, current);
                    current = new Sequence('*');
                    op = '+';
                }
                i[0]++;
            } else if (c == '(') {
                i[0]++;
                if (current.terms.size() > 0) {
                    addToStack(stack, current);
                    current = new Sequence('+');
                }

                Sequence subSequence = process(str, op, i);
                addToStack(stack, subSequence);

                // could be imporved here
                while (i[0] < str.length() && c != ')') c = str.charAt(i[0]++);
            } else if (c == ')') {
                Sequence mergedSequence = clearStack(stack, current);
                mergedSequence.op = initOp;
                return mergedSequence;
            } else if (c == ' ') {
                i[0]++;
            } else {
                int start = i[0];
                addTermToSequence(str, op, current, i);
                if ((i[0] < str.length()) && start > i[0]) {
                    addToStack(stack, current);
                    current = new Sequence(str.charAt(i[0]));
                }

                if (current.op == '*') {
                    addToStack(stack, current);
                    current = new Sequence('+');
                }
            }
        }
        if (current.terms.size() > 0) {
            addToStack(stack, current);
        }
        Sequence result = mergeStack(stack);
        return result;
    }

    private void addTermToSequence(String str, char op, Sequence sequence, int[] i) {
        Term term = new Term(op);
        StringBuilder sb = new StringBuilder();

        int start = i[0];
        char c = str.charAt(i[0]);
        while (i[0] < str.length()) {
            c = str.charAt(i[0]);

            if (c == '*') {
                term.add(sb.toString());
                sb = new StringBuilder();
            }

            // word for multiple letters
            while (i[0] < str.length()) {
                c = str.charAt(i[0]);

                if (!isSameWord(str, c, i)) {
                    break;
                }
                sb.append(c);
                i[0]++;
            }

            if (!isSameTerm(str, c, i)) {
                if (c == '(')  {
                    if (sequence.terms.size() > 0 && str.charAt(i[0] - 2) == '*') {
                        char checked = str.charAt(i[0]);
                        while (checked != '+' && checked != '-') {
                            i[0]--;
                            checked = str.charAt(i[0]);
                        }
                        return;
                    } else {
                        i[0] -= 2;
                    }
                }
                break;
            }
            i[0]++;
        }
        if (sb.length() > 0) term.add(sb.toString());
        sequence.add(term);
    }

    private boolean isSameTerm(String str, char c, int[] i) {
        if (c == '-' && str.charAt(i[0] + 1) != ' ') return true;
        if (c == '+' ||
            c == '-' ||
            c == '(' ||
            c == ')'
        ) return false;
        return true;
    }

    private boolean isSameWord(String str, char c, int[] i) {
        if (c == '-' && str.charAt(i[0] + 1) != ' ') return true;
        if (c == ' ' ||
            c == '*' ||
            c == '-' ||
            c == '+' ||
            c == '(' ||
            c == ')'
        ) return false;
        return true;
    }

    private boolean isNewSeq(char c) {
        if (c == '(') return true;
        return false;
    }

    private void addToStack(Stack<Sequence> stack, Sequence sequence) {
        if (sequence.terms.size() == 0) return;

        Sequence currentSequence = sequence;
        while (currentSequence.op == '*' &&
               !stack.isEmpty()) {

            Sequence prevSequence = stack.pop();
            currentSequence = currentSequence.multi(prevSequence);
        }
        stack.push(currentSequence);
    }

    private Sequence mergeStack(Stack<Sequence> stack) {
        Sequence sequence = stack.pop();
        while (stack.size() > 0) {
            sequence = sequence.add(stack.pop());
        }
        return sequence;
    }

    private Sequence clearStack(Stack<Sequence> stack, Sequence sequence) {
        if (stack.size() == 0) return sequence;

        while (!stack.isEmpty()) {
            Sequence prevSequence = stack.pop();

            if (prevSequence.terms.size() == 0) continue;
            sequence = sequence.add(prevSequence);
        }
        return sequence;
    }

    private String replaceString(String expression, String[] evalvars, int[] evalints) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                sb.append(c + " ");
            } else if (c == ')') {
                sb.append(" " + c);
            } else {
                sb.append(c);
            }
        }

        expression = sb.toString().trim();
        List<String> list = new ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < evalvars.length; i++) map.put(evalvars[i], evalints[i]);

        sb = new StringBuilder();
        String[] words = expression.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                sb.append(map.get(word) + " ");
            } else {
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }

    class Term {
        char op;
        int coef;
        List<String> vars;

        public Term(char op) {
            this.op = op;
            if (op == '+') {
                this.coef = 1;
            } else if (op == '-') {
                this.coef = -1;
            } else {
                System.out.println("error");
            }
            this.vars = new ArrayList();
        }

        public Term multi(Term t) {
            int newCoef = this.coef * t.coef;
            Term newT = null;
            if (newCoef >= 0) {
                newT = new Term('+');
            } else {
                newT = new Term('-');
            }
            newT.coef = newCoef;

            newT.vars.addAll(t.vars);
            newT.vars.addAll(this.vars);
            return newT;
        }

        public void add(String str) {
            if (isNumber(str)) {

                int num = toNumber(str);
                this.coef = this.coef * num;
            } else {
                this.vars.add(str);
            }
        }

        public boolean isNumber(String str) {
            char first = str.charAt(0);
            if (first != '-' && (first < '0' || first > '9')) return false;
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c < '0' || c > '9') return false;
            }
            return true;
        }

        public int toNumber(String str) {
            str = str.trim();
            int num = 0;
            char first = str.charAt(0);
            if (first != '-') num = first - '0';

            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                num = num * 10 + c - '0';
            }

            if (first == '-') num = -1 * num;
            return num;
        }

        public void sort() {
            Collections.sort(vars);
        }

        public String toStringWithoutCof() {
            if (vars.size() == 0) return "1";

            StringBuilder sb = new StringBuilder();
            Collections.sort(vars);
            for (int i = 0; i < vars.size(); i++) {
                sb.append(vars.get(i));
                if (i < vars.size() - 1) sb.append("*");
            }
            return sb.toString();
        }
    }

    class Sequence {
        List<Term> terms;
        char op;

        public Sequence(char op) {
            this.op = op;
            this.terms = new ArrayList();
        }

        public void add(Term t) {
            terms.add(t);
        }

        public Sequence multi(Sequence prevSequence) {
            Sequence newSequence = new Sequence(prevSequence.op);

            for (Term t1 : this.terms) {
                for (Term t2 : prevSequence.terms) {
                    Term newTerm = t1.multi(t2);
                    newSequence.add(newTerm);
                }
            }
            return newSequence;
        }

        public Sequence add(Sequence s) {
            if (s.op == '-') {
                for (Term t : s.terms) {
                    t.coef *= -1;
                }
                s.op = '+';
            }

            if (this.op == '-') {
                for (Term t : this.terms) {
                    t.coef *= -1;
                }
                this.op = '+';
            }
            Sequence newSequence = new Sequence(s.op);
            newSequence.terms.addAll(s.terms);
            newSequence.terms.addAll(this.terms);
            return newSequence;
        }

        public List<String> toList() {
            HashMap<String, Integer> map = new HashMap();
            Set<String> uniqueTerms = new HashSet();
            List<Term> sortedTerms = new ArrayList();

            for (Term term : this.terms) {
                String key = term.toStringWithoutCof();
                if (!uniqueTerms.contains(key)) {
                    uniqueTerms.add(key);
                    sortedTerms.add(term);
                }

                int coef = term.coef;
                if (this.op == '-') coef *= -1;
                map.put(key, map.getOrDefault(key, 0) + coef);
            }

            // wrong order
            List<String> list = new ArrayList();
            String num = null;
            Collections.sort(sortedTerms,
                             (a, b) -> b.vars.size() == a.vars.size() ?
                             a.toStringWithoutCof().compareTo(b.toStringWithoutCof()) :
                             b.vars.size() - a.vars.size()
                            );

            for (Term term : sortedTerms) {
                String key = term.toStringWithoutCof();
                Integer value = map.get(key);
                if (value == 0) continue;

                if (key.equals("1")) {
                    num = value + "";
                } else {
                    list.add(value + "*" + key);
                }
            }

            if (num != null) list.add(num);
            return list;
        }
    }
}
