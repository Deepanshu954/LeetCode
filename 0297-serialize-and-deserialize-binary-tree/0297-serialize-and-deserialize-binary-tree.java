public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val).append(" ");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    private int idx;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.trim().split(" ");
        idx = 0;
        return build(nodes);
    }

    private TreeNode build(String[] nodes) {
        if(idx == nodes.length) return null;

        String val = nodes[idx++];
        if(val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(nodes);
        node.right = build(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));