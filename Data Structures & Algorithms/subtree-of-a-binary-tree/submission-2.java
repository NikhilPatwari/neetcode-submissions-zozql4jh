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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null) {
            return false;
        }

        if(isSameTree(root, subroot)) return true;

        boolean isSubrootSameAsLeft = isSubtree(root.left, subroot);
        if (isSubrootSameAsLeft) return true;
        boolean isSubrootSameAsRight = isSubtree(root.right, subroot);
        if (isSubrootSameAsRight) return true;
        return false;
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) {
            return true;
        }else if(root1 != null && root2 != null && root1.val == root2.val) {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
