class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            switch(token){
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" ->{
                    int sec = stack.pop();
                    int first = stack.pop();
                    stack.push(first - sec);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int sec = stack.pop();
                    int first = stack.pop();
                    stack.push(first / sec);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}