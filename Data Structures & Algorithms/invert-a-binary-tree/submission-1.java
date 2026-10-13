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
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    public void inverse(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            return;
        }

        if(root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            inverse(root.left);
            return;
        }

        if(root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
            inverse(root.right);
            return;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = r;
        root.right = l;

        inverse(root.left);
        inverse(root.right);
        return;
        
    }
}
