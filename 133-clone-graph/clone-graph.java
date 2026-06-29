/*
// Definition for a Node.
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
    Node dfs(Node node, Map<Node, Node> copyNodes) {
        if (copyNodes.containsKey(node)) {
            return copyNodes.get(node);
        }
        Node copy = new Node(node.val);
        copyNodes.put(node, copy);
        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, copyNodes));
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> copyNodes = new HashMap<>();
        return dfs(node, copyNodes);
    }
}