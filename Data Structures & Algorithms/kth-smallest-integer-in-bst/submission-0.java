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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> ls = new ArrayList<>();
        inorder(root,ls);
        int small = ls.get(k-1).val;
        return small;
    }

    public void inorder(TreeNode root, List<TreeNode> ls) {
        if(root == null) {
            return;
        }

        inorder(root.left,ls);
        ls.add(root);
        inorder(root.right,ls);
        return;
    }
}
