class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String , PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0) , k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs("JFK" , map , res);

        return res.reversed();
    }
    private void dfs(String city , Map<String , PriorityQueue<String>> map , List<String> res){
        PriorityQueue<String> pq = map.get(city); // tickets

        while(pq != null && !pq.isEmpty()){
            String nextCity = pq.poll();
            dfs(nextCity , map , res);
        }

        res.add(city); // last city
    }
}