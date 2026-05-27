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
    public int maxPath = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return maxPath;

    }

    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = 0, right = 0,max = 0;
        if(root.left != null) {
            left = 1+ diameterOfBinaryTreeHelper(root.left);
            max += left;
        }

        if(root.right != null){
            right = 1 + diameterOfBinaryTreeHelper(root.right);
            max += right;
        }
        if(max > maxPath){
            maxPath = max;
        }
        return Math.max(left, right);
    }
}
