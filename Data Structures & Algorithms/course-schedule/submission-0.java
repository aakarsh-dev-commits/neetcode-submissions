class Solution {

    Map<Integer,List<Integer>> map;
    Set<Integer> set;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        set = new HashSet<>();

        for(int i = 0 ; i < numCourses ; i++) {
            map.put(i , new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0 ; i < numCourses ; i++) {
            if(!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int i) {
        if(set.contains(i)) {
            return false;
        }

        if(map.get(i).isEmpty()) {
            return true;
        }

        set.add(i);

        for(int j : map.get(i)) {
            if(!dfs(j)) {
                return false;
            }
        }

        set.remove(i);

        map.put(i,new ArrayList<>());

        return true;

    }
}
