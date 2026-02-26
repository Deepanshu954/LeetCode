public class Codec {

    private int i;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val).append(" ");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        i = 0;
        return build(data);
    }

    private TreeNode build(String data) {

        if (i >= data.length()) return null;

        if (data.charAt(i) == '#') {
            i += 2; // skip "# "
            return null;
        }

        int sign = 1;
        if (data.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        while (i < data.length() && data.charAt(i) != ' ') {
            num = num * 10 + (data.charAt(i) - '0');
            i++;
        }

        i++; // skip space

        TreeNode node = new TreeNode(sign * num);
        node.left = build(data);
        node.right = build(data);

        return node;
    }
}