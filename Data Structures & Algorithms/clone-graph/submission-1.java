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
        if(node == null){
            return null;
        }
        Map<Node, Node> oldNewMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Node newNode = new Node(node.val);
        oldNewMap.put(node,newNode);
        cloneAdjacencyList(newNode, node, oldNewMap);
        return newNode;
    }
    public void cloneAdjacencyList(Node newNode, Node node, Map<Node, Node> oldNewMap) {
        for (Node n : node.neighbors) {
            if (oldNewMap.containsKey(n)) {
                newNode.neighbors.add(oldNewMap.get(n));
            } else {
                Node temp = new Node(n.val);
                oldNewMap.put(n, temp);
                newNode.neighbors.add(temp);
                cloneAdjacencyList(temp, n, oldNewMap);
            }
        }
    }
}