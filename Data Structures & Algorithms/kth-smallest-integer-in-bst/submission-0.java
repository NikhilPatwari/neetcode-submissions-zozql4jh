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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int [] a  = new int[] {0};
        return kthSmallestValue(root, k,a);
    }
     public int kthSmallestValue(TreeNode root, int k, int[] a) {
        if(root == null){
            return -1;
        }
        int l = kthSmallestValue(root.left, k, a);
        if(a[0] == k){
            return l;
        }
        a[0]++;
        if(a[0] == k){
            return root.val;
        }
        int r = kthSmallestValue(root.right, k, a);
        if(a[0] == k){
            return r;
        }
        return -1;
     }
}
