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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (sameTree(root, subRoot)) {
                return true;
            } else {
                if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            if (sameTree(p.left, q.left) && sameTree(p.right, q.right)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
