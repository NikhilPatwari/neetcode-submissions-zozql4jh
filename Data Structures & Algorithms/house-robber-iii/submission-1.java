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
    Map<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        if (root == null)
            return 0;
        int l = 0, r = 0;
        if (root.left != null) {
            l = rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            r = rob(root.right.left) + rob(root.right.right);
        }
        dp.put(root, Math.max(root.val + l + r, rob(root.left) + rob(root.right)));
        return dp.get(root);
    }
}