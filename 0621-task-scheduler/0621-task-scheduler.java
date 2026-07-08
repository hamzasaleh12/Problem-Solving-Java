class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task , map.getOrDefault(task,0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b) , map.get(a)));
        for(char ch : map.keySet()){
            pq.add(ch); // [A,B]
        }

        int count = tasks.length; // 6
        while(!pq.isEmpty()){
            List<Character> list = new ArrayList<>();
            for(int i = 0 ; i <= n ; i++){ // 0,1,2
                if(pq.isEmpty()){ // idle
                    if(!list.isEmpty()) count++; // 8
                    continue;
                }
                char currChar = pq.poll(); // A,B
                map.put(currChar , map.get(currChar) - 1); // [A:0 , B:0]
                if(map.get(currChar) > 0) list.add(currChar); // []
            }

            for(char ch : list){
                pq.add(ch); // [A,B]
            }
        }
        return count;
    }
}