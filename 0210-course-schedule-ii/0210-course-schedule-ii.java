class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            map.computeIfAbsent(pre[0] , k -> new ArrayList<>()).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(i , visited , result , map)) return new int[0];
        }

        int count = 0;
        int[] res = new int[numCourses];
        for(int r : result){
            res[count++] = r;
        }
        return res;
    }
    private boolean dfs(int key , int[] visited , List<Integer> result , Map<Integer,List<Integer>> map){
        if(visited[key] == 1) return false;
        if(visited[key] == 2) return true;
        
        visited[key]++;
        for(int neighbor : map.getOrDefault(key, new ArrayList<>())){
            if(!dfs(neighbor , visited , result , map)) return false;
        }

        visited[key]++;
        result.add(key);

        return true;
    }
}