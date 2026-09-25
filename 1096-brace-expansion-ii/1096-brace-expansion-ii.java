class Solution {
    private int idx = 0;
    private String expr;

    public List<String> braceExpansionII(String expression) {
        this.expr = expression;
        this.idx = 0;

        Set<String> resultSet = parseExpression();
        
        List<String> sortedList = new ArrayList<>(resultSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    private Set<String> parseExpression() {
        Set<String> res = parseTerm();

        while (idx < expr.length() && expr.charAt(idx) == ',') {
            idx++;
            res.addAll(parseTerm());
        }

        return res;
    }

    private Set<String> parseTerm() {
        Set<String> res = new HashSet<>();
        res.add("");

        while (idx < expr.length() && (Character.isLetter(expr.charAt(idx)) || expr.charAt(idx) == '{')) {
            Set<String> nextFactor = parseFactor();
            res = multiply(res, nextFactor);
        }

        return res;
    }

    private Set<String> parseFactor() {
        if (expr.charAt(idx) == '{') {
            idx++;
            Set<String> inner = parseExpression();
            idx++;
            return inner;
        } else {
            StringBuilder sb = new StringBuilder();
            while (idx < expr.length() && Character.isLetter(expr.charAt(idx))) {
                sb.append(expr.charAt(idx++));
            }
            return Collections.singleton(sb.toString());
        }
    }

    private Set<String> multiply(Set<String> s1, Set<String> s2) {
        Set<String> prod = new HashSet<>();
        for (String a : s1) {
            for (String b : s2) {
                prod.add(a + b);
            }
        }
        return prod;
    }
}