/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Deque<Node> dq = new LinkedList<>();
        dq.addFirst(root);

        while(!dq.isEmpty()) {
            int size = dq.size();

            Node prev = null;

            for(int i = 0; i < size; i++) {
                Node node = dq.removeLast();

                if(node.left != null) dq.addFirst(node.left);
                if(node.right != null) dq.addFirst(node.right);

                if(prev != null) prev.next = node;
                prev = node;
                if(i == size - 1) {
                    node.next = null;
                    break;
                }

                
            }

        }

        return root;
    }
}