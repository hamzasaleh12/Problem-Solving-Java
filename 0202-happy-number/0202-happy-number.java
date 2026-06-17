class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            slow = helper(slow);
            fast = helper(helper(fast));

            if(fast == 1) return true;
            else if(slow == fast) return false;
        }
    }
    private int helper(int n){
        int sum = 0;
        while(n > 0){
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }
}