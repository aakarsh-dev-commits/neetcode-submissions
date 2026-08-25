class Solution {
    Deque<int[]> stack;
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        stack = new ArrayDeque<>();

        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }

        for (int[] i : edges) {
            int a = parent(i[0]);
            int b = parent(i[1]);

            if (a == b) {
                stack.push(i);
            }
            parent[a] = b;
        }

        return stack.pop();
    }

    public int parent(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent(parent[i]);
    }

    // public boolean connected(List<int[]> ls) {
    //     int n = ls.size() + 1;
    //     int components = n;
    //     parent = new int[n + 1];
    //     for (int i = 1; i < n + 1; i++) {
    //         parent[i] = i;
    //     }

    //     for (int[] i : ls) {
    //         int a = parent(i[0]);
    //         int b = parent(i[1]);

    //         if (a != b) {
    //             parent[a] = b;
    //             components--;
    //         }
    //     }

    //     if (components == 1) {
    //         return true;
    //     }

    //     return false;
    // }
}