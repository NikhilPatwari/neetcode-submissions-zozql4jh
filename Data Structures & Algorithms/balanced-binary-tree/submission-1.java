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
        return isBalancedHelper(root).isBalanced;
    }
    public Pair isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }
        Pair left = isBalancedHelper(root.left);
        if (!left.isBalanced) {
            return new Pair(0, false);
        }
        Pair right = isBalancedHelper(root.right);
        if (!right.isBalanced) {
            return new Pair(0, false);
        }

        if (Math.abs(left.height - right.height) <= 1) {
            return new Pair(1 + Math.max(left.height, right.height), true);
        } else {
            return new Pair(0, false);
        }
    }
}
class Pair {
    public int height;
    public boolean isBalanced;
    public Pair(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
