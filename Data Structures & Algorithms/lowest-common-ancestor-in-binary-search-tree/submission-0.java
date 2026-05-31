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
    Map<TreeNode, Pair> nodePQHeight = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    TreeNode minNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findHeight(root, p, true);
        findHeight(root, q, false);
        return minNode;
    }
    public int findHeight(TreeNode root, TreeNode x, boolean isP) {
        int height = 0;
        Pair p = null;
        if (nodePQHeight.containsKey(root)) {
            p = nodePQHeight.get(root);
        } else {
            p = new Pair();
            nodePQHeight.put(root, p);
        }

        if (root.val == x.val) {
            if (isP) {
                p.pHeight = 0;
            } else {
                p.qHeight = 0;
            }
            height = 0;
        } else if (root.val > x.val) {
            height = 1 + findHeight(root.left, x, isP);
            if (isP) {
                p.pHeight = height;
            } else {
                p.qHeight = height;
            }
        } else {
            height = 1 + findHeight(root.right, x,isP);
            if (isP) {
                p.pHeight = height;
            } else {
                p.qHeight = height;
            }
        }
        if (p.pHeight != null && p.qHeight != null) {
            int total = p.pHeight + p.qHeight;
            if (total < minDistance) {
                minDistance = total;
                minNode = root;
            }
        }
        return height;
    }
}
class Pair {
    public Integer pHeight;
    public Integer qHeight;
    public void Pair() {
        
    }
}
