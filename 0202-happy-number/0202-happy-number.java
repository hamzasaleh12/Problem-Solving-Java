class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) { // 19
        if(n == 1) return true;
        else if(!set.add(n)) return false;

        int sum = 0;
        while(n / 10 != 0){
            int num = n % 10; // 9
            sum += num * num;  // 81
            n /= 10; // 1
        }
        sum += n * n;
        return isHappy(sum);
    }
}