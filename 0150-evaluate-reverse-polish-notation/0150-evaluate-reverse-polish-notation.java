class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int sum = 0;
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                int secNum = (stack.isEmpty()) ? 0 : stack.pop();
                int firNum = (stack.isEmpty()) ? 0 : stack.pop();

                if(token.equals("+")){
                    sum = firNum + secNum;
                } else if(token.equals("-")){
                    sum = firNum - secNum;
                } else if(token.equals("*")){
                    sum = firNum * secNum;
                } else{
                    sum = firNum / secNum;
                }
                stack.push(sum);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}