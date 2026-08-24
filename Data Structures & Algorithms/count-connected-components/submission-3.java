class Solution {
    HashMap<Integer, Integer> map;
    Set<Integer> set;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }

        for (int[] i : edges) {
            int child = parent(i[1]);
            int parent = parent(i[0]);

            if (child != parent) {
                map.put(child, parent);
            }
        }

        for (int i = 0; i < n; i++) {
            set.add(parent(i));
        }

        return set.size();
    }

    public int parent(int i) {
        if (map.get(i) == i) {
            return i;
        }

        return parent(map.get(i));
    }
}
