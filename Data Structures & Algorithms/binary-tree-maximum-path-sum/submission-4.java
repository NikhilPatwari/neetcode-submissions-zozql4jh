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
        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int max = root.val;
        if(root.left != null && root.right != null){
            int left = maxPath(root.left);
            int right = maxPath(root.right);
            maxSum = Math.max(maxSum, Math.max(root.val, Math.max(root.val + left,
                Math.max(root.val + right,root.val + left + right))));
            return Math.max(root.val, Math.max(root.val + left, root.val + right));
        }else if(root.left != null) {
            int left = maxPath(root.left);
            maxSum = Math.max(maxSum, Math.max(root.val,root.val + left));
            return Math.max(root.val,root.val + left);
        }else{
            int right = maxPath(root.right);
            maxSum = Math.max(maxSum, Math.max(root.val,root.val + right));
            return Math.max(root.val,root.val + right);
        }
    }
}
