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
    TreeNode D = new TreeNode(-6000); // Delimiter
    TreeNode N = new TreeNode(-5000);
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(D);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.val == -5000){
                sb.append("1001#");
            }else if(temp.val >= -1000 && temp.val<=1000){
                sb.append(temp.val + "#");
            }
            if(temp == N){
                continue;
            }else if(temp == D && !q.isEmpty()){
                q.offer(D);
            }else{
                if(temp.left == null){
                    q.offer(N);
                }else{
                    q.offer(temp.left);
                }
                if(temp.right == null){
                    q.offer(N);
                }else{
                    q.offer(temp.right);
                }
            }
        }
        // String s = sb.toString();
        // System.out.println(s);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        List<Integer> l = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        int i = 0;
        while(i<data.length()) {
            int n = findNextIndex(data,i);
            int val = Integer.parseInt(data.substring(i,n));
            q.offer(val);
            i = n+1;
        }
        queue.offer(convertToNode(q.poll()));
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(root == null){
                root = temp;
            }
            TreeNode left = convertToNode(q.poll());
            TreeNode right = convertToNode(q.poll());
            if(left != null){
                temp.left = left;
                queue.offer(left);
            }
            if(right != null){
                temp.right = right;
                queue.offer(right);
            }
            
        }
        return root;
        
    }
    private TreeNode convertToNode(int val){
        if(val == 1001){
            return null;
        }else {
            return new TreeNode(val);
        }
    }
    private int findNextIndex(String s, int i){
        while(i < s.length() && s.charAt(i) != '#'){
            i++;
        }
        return i;
    }
}
