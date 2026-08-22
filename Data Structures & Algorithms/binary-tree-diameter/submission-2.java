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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] result = new int []{0};
        diameter(root, result);
        return result[0];
    }
    public int diameter(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }
        int max = 0;
        if(root.left != null && root.right != null){
            int leftDiameter = 1+diameter(root.left,result);
            int rightDiameter = 1+ diameter(root.right, result);
            max = Math.max(leftDiameter, rightDiameter );
            result[0] = Math.max(result[0],leftDiameter+ rightDiameter);
        }else if(root.left != null){
            int leftDiameter = 1+diameter(root.left,result);
            max = Math.max(leftDiameter, max );
            result[0] = Math.max(result[0],leftDiameter);
        }else if(root.right != null){
            int rightDiameter = 1+ diameter(root.right, result);
            max = Math.max(max, rightDiameter );
            result[0] = Math.max(result[0],rightDiameter);
        }else{
            return 0;
        }
        return max;
    }
}
