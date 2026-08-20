class Solution {
    Map<Integer, ArrayList<Integer>> map;
    HashSet<Integer> set;
    List<Integer> ls;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        set = new HashSet<>();
        map = new HashMap<>();
        ls = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        if (!ls.isEmpty()) {
            for (int i = 0; i < numCourses; i++) {
                if (!ls.contains(i)) {
                    ls.add(i);
                }
            }

            int[] arr = ls.stream().mapToInt(Integer::intValue).toArray();

            return arr;
        }

        return new int[0];
    }

    public boolean dfs(int i) {
        if (set.contains(i)) {
            return false;
        }

        if (map.get(i).isEmpty()) {
            if (!ls.contains(i)) {
                ls.add(i);
            }
            return true;
        }

        set.add(i);

        for (int j : map.get(i)) {
            if (!dfs(j)) {
                return false;
            }
        }

        set.remove(i);

        map.put(i, new ArrayList<>());
        if (!ls.contains(i)) {
            ls.add(i);
        }
        return true;
    }
}
