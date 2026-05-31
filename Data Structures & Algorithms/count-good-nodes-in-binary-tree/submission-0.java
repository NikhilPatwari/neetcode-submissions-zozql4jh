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
    int count  = 0;
    public int goodNodes(TreeNode root) {
        greatNodes(root,-200);
        return count;
    }
    public void greatNodes(TreeNode root, int maxValue){
        if(root == null){
            return;
        }
        if(root.val >= maxValue){
            count++;
        }
        greatNodes(root.left, Math.max(maxValue,root.val));
        greatNodes(root.right, Math.max(maxValue,root.val));
    }

}
