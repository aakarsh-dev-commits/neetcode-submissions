class Solution {
    HashSet<Integer> set;
    HashMap<Integer, ArrayList<Integer>> map;
    public boolean validTree(int n, int[][] edges) {
        set = new HashSet<>();
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, -1)) {
            return false;
        }

        return n==set.size();
    }

    public boolean dfs(int curr, int parent) {
        if (set.contains(curr)) {
            return false;
        }

        set.add(curr);

        for (int j : map.get(curr)) {
            if (j == parent) {
                continue;
            }
            if (!dfs(j, curr)) {
                return false;
            }
        }
        return true;
    }
}
