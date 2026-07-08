class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        int max = 0;
        for(char task : tasks){
            max = Math.max(max ,++arr[task - 'A']);
        }

        int countMaxFre = 0;
        for(int a : arr) if(a == max) countMaxFre++;

        return Math.max(tasks.length , (max - 1) * (n + 1) + countMaxFre);
    }
}