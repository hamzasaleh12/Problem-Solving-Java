class Solution {
    public boolean isValid(String s) {
        //  اوبجيكت من الستاك اللي عملناه
        Deque<Character> stack = new ArrayDeque<>(); 
        // امشي علي حروف الكلمه
        for (char c : s.toCharArray()) {
            // لو لقيت فتحه قوس حطه في الستاك
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                // قارن اللي علي وش الستاك بالحرف اللي عليه الدور
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        // لو الستاك فضي بعد ده رجع صح غير كده بيرجع غلط
        return stack.isEmpty();
    }
}