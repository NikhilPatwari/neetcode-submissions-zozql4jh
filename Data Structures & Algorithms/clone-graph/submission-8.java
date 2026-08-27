/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(node.val);
        map.put(node, root);
        q.offer(node);
        Set<Node> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited.contains(n)) {
                continue;
            }
            Node temp = map.get(n);
            for (Node l : n.neighbors) {
                temp.neighbors.add(map.computeIfAbsent(l, k -> new Node(l.val)));
                if (!visited.contains(l)) {
                    q.offer(l);
                }
            }
            visited.add(n);
        }
        return root;
    }
}