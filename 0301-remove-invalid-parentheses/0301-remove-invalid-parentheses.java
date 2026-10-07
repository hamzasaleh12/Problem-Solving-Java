class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int remOpen = 0, remClose = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                remOpen++;
            } else if (c == ')') {
                if (remOpen > 0) remOpen--;
                else remClose++;
            }
        }

        Set<String> result = new HashSet<>();
        dfs(0, remOpen, remClose, 0, s, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void dfs(int i, int remOpen, int remClose, int balance, String s, StringBuilder sb, Set<String> res) {
        if (remOpen < 0 || remClose < 0 || balance < 0) {
            return;
        }

        if (i == s.length()) {
            if (remOpen == 0 && remClose == 0 && balance == 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            dfs(i + 1, remOpen - 1, remClose, balance, s, sb, res);
        } else if (c == ')') {
            dfs(i + 1, remOpen, remClose - 1, balance, s, sb, res);
        }


        sb.append(c);
        if (c == '(') {
            dfs(i + 1, remOpen, remClose, balance + 1, s, sb, res);
        } else if (c == ')') {
            dfs(i + 1, remOpen, remClose, balance - 1, s, sb, res);
        } else {
            dfs(i + 1, remOpen, remClose, balance, s, sb, res);
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}