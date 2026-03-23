class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1; // Pointer لآخر عنصر

        for (String s : tokens) {
            char c = s.charAt(0);
            
            if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int val2 = stack[top--];
                int val1 = stack[top--];
                
                switch (c) {
                    case '+' -> stack[++top] = val1 + val2;
                    case '-' -> stack[++top] = val1 - val2;
                    case '*' -> stack[++top] = val1 * val2;
                    case '/' -> stack[++top] = val1 / val2;
                }
            } else {
                stack[++top] = Integer.parseInt(s);
            }
        }
        return stack[top];
    }
}