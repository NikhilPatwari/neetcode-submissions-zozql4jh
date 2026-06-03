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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String s = sb.toString();
        return s.substring(1);
    }
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",N");
            return;
        }
        sb.append(",");
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int [] index = new int []{0};
        return deserialize(vals,index);

    }
    public TreeNode deserialize(String[] vals, int [] index) {
        if(index[0] >= vals.length || vals[index[0]].equals("") || vals[index[0]].equals("N") ){
            if(vals[index[0]].equals("N")){
                index[0]++;
            }
            return null;
        }
        TreeNode n = new TreeNode(Integer.valueOf(vals[index[0]]));
        index[0]++;
        n.left = deserialize(vals, index);
        n.right = deserialize(vals, index);
        return n;
    }
}
