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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return depth;
        }
        TreeNode delim = new TreeNode(-1);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(delim);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == delim){
                depth++;
                if(q.isEmpty()){
                    return depth;
                }else{
                    q.add(delim);
                }
            }else{
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
        }
        return depth;
    }
}
