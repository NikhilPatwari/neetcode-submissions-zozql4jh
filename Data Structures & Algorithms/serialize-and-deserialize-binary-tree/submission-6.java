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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(" ");
        int[] i = new int[] {0};
        return constructTree(strings, i);
    }
    public TreeNode constructTree(String[] strings, int[] i) {
        if (i[0] > strings.length) {
            return null;
        }
        TreeNode n = convertToNode(strings[i[0]]);
        if (n == null)
            return null;
        i[0]++;
        n.left = constructTree(strings, i);
        i[0]++;
        n.right = constructTree(strings, i);
        return n;
    }
    private TreeNode convertToNode(String val) {
        if (val.equals("N")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }
}
