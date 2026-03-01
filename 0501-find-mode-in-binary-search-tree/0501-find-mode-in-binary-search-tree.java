class Solution {

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        int[] state = new int[3]; 
        // state[0] = prev
        // state[1] = count
        // state[2] = maxCount
        boolean[] first = new boolean[]{true};

        inorder(root, modes, state, first);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node, List<Integer> modes, int[] state, boolean[] first) {
        if (node == null) return;

        inorder(node.left, modes, state, first);

        if (first[0]) {
            state[0] = node.val;
            state[1] = 1;
            state[2] = 1;
            modes.add(node.val);
            first[0] = false;
        } else {
            if (node.val == state[0]) {
                state[1]++;
            } else {
                state[0] = node.val;
                state[1] = 1;
            }

            if (state[1] > state[2]) {
                state[2] = state[1];
                modes.clear();
                modes.add(node.val);
            } else if (state[1] == state[2]) {
                modes.add(node.val);
            }
        }

        inorder(node.right, modes, state, first);
    }
}