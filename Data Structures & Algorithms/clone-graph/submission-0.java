/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, List<Node>> map;
    HashMap<Node, Node> map2;
    HashMap<Node, Boolean> map3;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        map = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();
        dfs(node);
        assign(node);

        return map2.get(node);
    }

    public void assign(Node node) {
        if (!map3.get(node)) {
            map3.put(node, true);
            Node nexNode = map2.get(node);
            for (Node n : map.get(node)) {
                nexNode.neighbors.add(map2.get(n));
                assign(n);
            }
        }
    }

    public void dfs(Node node) {
        map.put(node, node.neighbors);
        Node newNode = new Node(node.val);
        map2.put(node, newNode);
        map3.put(node, false);
        for (Node n : map.get(node)) {
            if (!map.containsKey(n)) {
                dfs(n);
            }
        }
    }
}