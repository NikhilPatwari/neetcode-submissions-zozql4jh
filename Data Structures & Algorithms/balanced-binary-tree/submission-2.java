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
        Pair p = dfs(root);
        return p.balanced;
        
    }
    public Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(0,true);
        }
        Pair left = dfs(root.left);
        if(!left.balanced){
            return left;
        }
        Pair right = dfs(root.right);
        if(!right.balanced){
            return right;
        }
        boolean balanced = Math.abs(left.height - right.height) <= 1;
        int height = 1+ Math.max(left.height, right.height);
        return new Pair(height, balanced);
    }
}
class Pair{
    int height;
    boolean balanced;
    public Pair(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}
