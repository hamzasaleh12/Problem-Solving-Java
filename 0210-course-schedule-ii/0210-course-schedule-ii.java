class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++) adj[i] = new ArrayList<>();

        for(int[] prerequisite : prerequisites){
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        
        int[] visited = new int[numCourses];
        int[] res = new int[numCourses];

        int[] courses = {numCourses};
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(adj , visited , res , i , courses)) return new int[]{};
        }

        return res;
    }
    private boolean dfs(List<Integer>[] adj , int[] visited , int[] res , int num , int[] numCourses){
        if(visited[num] == 2) return true;
        if(visited[num] == 1) return false;

        visited[num] = 1;
        for(int i : adj[num]){
            if(!dfs(adj , visited , res , i , numCourses)) return false;
        }
        visited[num] = 2;

        res[--numCourses[0]] = num;

        return true;
    }
}