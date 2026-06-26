/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls1 = new ArrayList<>();
        if(root == null) {
            return ls1;
        }
        q.offer(root);
        ordering(q,ls1);
        return ls1;
    }

    public void ordering(Queue<TreeNode> q , List<List<Integer>> ls1 ) {

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            list.add(temp.val);
            if(temp.left != null) {
                qu.offer(temp.left );
            }
            if(temp.right != null) {
                qu.offer(temp.right );
            }
        }

        ls1.add(list);

        if(qu.isEmpty()) {
            return;
        } else {
            ordering(qu , ls1);
            return;
        }
        

    }
}
