class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        int components = n;

        for(int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }

        for(int[] i : edges) {
            int a = find(i[0]);
            int b = find(i[1]);

            if(a != b) {
                parent[a] = b;
                components--;
            }
        }

        return components;
    }

    public int find(int i) {
        if(i == parent[i]) {
            return i;
        }

        return find(parent[i]);
    }
}
