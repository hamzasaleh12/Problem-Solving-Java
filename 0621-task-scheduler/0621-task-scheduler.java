class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task , map.getOrDefault(task,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b , a));
        for(char ch : map.keySet()){
            pq.add(map.get(ch)); // [3,3]
        }

        int count = tasks.length; // 6
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i <= n ; i++){ // 0,1,2
                if(pq.isEmpty()){ // idle
                    if(!list.isEmpty()) count++; // 8
                    continue;
                }
                int fre = pq.poll(); // 3,3
                if(fre - 1 > 0) list.add(fre - 1);
            }

            for(int num : list){
                pq.add(num); // [A,B]
            }
        }
        return count;
    }
}