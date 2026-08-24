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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return root;
        }
        if(root.left != null && isLeaf(root.left) && root.left.val == target){
            root.left = null;
        }
        if(root.right != null && isLeaf(root.right) && root.right.val == target){
            root.right = null;
        }

        if(root.left != null){
            root.left = removeLeafNodes(root.left, target );
        }
        if(root.right != null){
            root.right = removeLeafNodes(root.right, target );
        }
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
        
    }
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}