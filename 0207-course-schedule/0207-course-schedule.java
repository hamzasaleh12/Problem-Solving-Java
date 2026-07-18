class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++) adj[i] = new ArrayList<>();

        for(int[] prerequisite : prerequisites){
            adj[prerequisite[1]].add(prerequisite[0]);
        }

        // Cycle Detetction
        int[] isVisisted = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(adj , i , isVisisted)) return false;
        }

        return true;
    }
    private boolean dfs(List<Integer>[] adj , int course , int[] isVisisted){
        if(isVisisted[course] == 2) return true;
        if(isVisisted[course] == 1) return false; // It should be a cycle

        isVisisted[course] = 1;
        for(int num : adj[course]){
            if(!dfs(adj , num , isVisisted)) return false;
        }
        isVisisted[course] = 2;

        return true;
    }
}