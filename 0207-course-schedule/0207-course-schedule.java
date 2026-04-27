class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            map.computeIfAbsent(pre[0] , k -> new ArrayList<>()).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(i , visited , map)) return false;
        }

        return true;
    }
    private boolean dfs(int key , int[] visited , Map<Integer,List<Integer>> map){
        if(visited[key] == 1) return false;
        if(visited[key] == 2) return true;
        visited[key]++; // 1
        if(map.get(key) != null){
            for(int n : map.get(key)){
                if(!dfs(n , visited , map)) return false;
            }
        }
        visited[key]++; // 2
        return true;
    }
}