class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            int temp = temps[i];

            while(!stack.isEmpty() && temps[stack.peek()] < temp){
                int idx = stack.pop();
                res[idx] = i - idx;
            }

            stack.push(i);
        }

        return res;
    }
}