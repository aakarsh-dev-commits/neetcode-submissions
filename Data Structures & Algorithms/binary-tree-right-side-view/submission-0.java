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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        if(root == null) {
            return ls;
        } 
        q.offer(root);
        rightSide(q,ls);

        return ls;


    }

    public void rightSide( Queue<TreeNode> q , List<Integer> ls) {
        Queue<TreeNode> qu = new LinkedList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(q.isEmpty()) {
                ls.add(curr.val);
            }
            if(curr.right == null && curr.left == null) {
                continue;
            } 
            if(curr.right == null && curr.left != null) {
                qu.offer(curr.left);
                continue;
            }

            if(curr.left == null && curr.right != null) {
                qu.offer(curr.right);
                continue;
            }

            qu.offer(curr.left);
            qu.offer(curr.right);

        }

        if(qu.isEmpty()) {
            return;
        }

        rightSide(qu , ls);
        return;
    }

}
