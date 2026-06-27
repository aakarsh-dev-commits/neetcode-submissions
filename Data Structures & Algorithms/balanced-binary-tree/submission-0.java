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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isBalanced(root.left)) {
            if (height(root.left) - height(root.right) == 0
                || height(root.left) - height(root.right) == 1
                || height(root.left) - height(root.right) == -1) {
                if (isBalanced(root.right)) {
                    if (height(root.left) - height(root.right) == 0
                        || height(root.left) - height(root.right) == 1
                        || height(root.left) - height(root.right) == -1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
