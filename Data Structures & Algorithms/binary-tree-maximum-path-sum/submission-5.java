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
    int maxSum = -5000;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }
    public int maxPath(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMax = Math.max(maxPath(root.left),0);
        int rightMax = Math.max(maxPath(root.right),0);
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
