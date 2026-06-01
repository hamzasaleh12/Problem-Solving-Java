class Solution {
    public boolean checkValidString(String s) {
        ArrayDeque<Integer> openStack = new ArrayDeque<>();
        ArrayDeque<Integer> starStack = new ArrayDeque<>();

        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            if(curr == '('){
                openStack.push(i);
            } else if(curr == '*'){
                starStack.push(i);
            } else{ // clean
                if(openStack.isEmpty()){
                    if(starStack.isEmpty()) return false;
                    starStack.pop();
                } else{
                    openStack.pop();
                }
            }
        }

        while(!openStack.isEmpty() && !starStack.isEmpty()){
            if(openStack.pop() > starStack.pop()) return false;
        }

        return openStack.isEmpty();
    }
}