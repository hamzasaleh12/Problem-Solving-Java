class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            map.computeIfAbsent(prerequisite[1] , k -> new ArrayList<>()).add(prerequisite[0]); // 0 -> 1
        }

        // Cycle Detetction
        int[] isVisisted = new int[numCourses];

        for(int[] num : prerequisites){
            if(!dfs(map , num[1] , isVisisted)) return false;
        }

        return true;
    }
    private boolean dfs(Map<Integer,List<Integer>> map , int course , int[] isVisisted){
        if(isVisisted[course] == 2) return true;
        if(isVisisted[course] == 1) return false;

        isVisisted[course]++;
        for(int num : map.getOrDefault(course , new ArrayList<>())){
            if(!dfs(map , num , isVisisted)) return false;
        }
        isVisisted[course]++;

        return true;
    }

}