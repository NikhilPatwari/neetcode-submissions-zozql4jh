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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    public int maxPathSum(TreeNode root, int[] max) {
        if (root.left != null && root.right != null) {
            int l = maxPathSum(root.left, max);
            int r = maxPathSum(root.right, max);

            int overAllMaxSum = Math.max(root.val + l + r,
                Math.max(root.val + l, Math.max(root.val + r, Math.max(r, Math.max(l, root.val)))));
            if (overAllMaxSum > max[0]) {
                max[0] = overAllMaxSum;
            }

            return  Math.max(root.val + l, Math.max(root.val + r, root.val));
        } else if (root.left != null) {
            int l = maxPathSum(root.left, max);
            int overAllMaxSum = Math.max(root.val, Math.max(root.val + l, l));
            if (overAllMaxSum > max[0]) {
                max[0] = overAllMaxSum;
            }

            return Math.max(root.val + l, root.val);
        } else if (root.right != null) {
            int r = maxPathSum(root.right, max);
            int overAllMaxSum = Math.max(root.val, Math.max(root.val + r, r));
            if (overAllMaxSum > max[0]) {
                max[0] = overAllMaxSum;
            }

            return Math.max(root.val + r, root.val);
        } else {
            if (root.val > max[0]) {
                max[0] = root.val;
            }
            return root.val;
        }
    }
}
