class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> Integer.compare(b , a));

        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }

        for(int f : freq) if(f > 0) pq.add(f);

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int taskCount = 0;
            
            for(int i = 0 ; i < n + 1 ; i++){
                if(!pq.isEmpty()){
                    int tem = pq.poll();
                    if(tem > 1) temp.add(tem - 1);
                    taskCount++;
                }
            }
            for(int t : temp) pq.add(t);
            time += (pq.isEmpty()) ? taskCount : n + 1;
        }

        return time;
    }
}