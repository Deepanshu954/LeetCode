class Solution {

    // Node represents one unique palindrome
    static class Node {
        int len;            // length of palindrome
        int link;           // suffix link
        int[] next = new int[26]; // transitions
        Node(int l) { len = l; }
    }

    Node[] tree;
    int size;              // number of nodes
    int last;              // node of longest suffix palindrome
    String s;
    int maxLen = 0;        // longest palindrome length
    int endPos = 0;        // ending position of longest palindrome

    public String longestPalindrome(String str) {
        initTree();
        s = "";

        for (int i = 0; i < str.length(); i++) {
            addChar(str.charAt(i), i);
        }

        // extract answer
        return str.substring(endPos - maxLen + 1, endPos + 1);
    }

    // Initialize tree with 2 roots
    private void initTree() {
        tree = new Node[1005];
        tree[0] = new Node(-1); // imaginary root
        tree[1] = new Node(0);  // empty string root
        tree[0].link = 0;
        tree[1].link = 0;
        size = 2;
        last = 1;
    }

    // Add one character to the tree
    private void addChar(char ch, int pos) {
        s += ch;
        int cur = last;

        // Find longest suffix palindrome that can be extended
        while (true) {
            int curLen = tree[cur].len;
            if (pos - 1 - curLen >= 0 && s.charAt(pos - 1 - curLen) == ch)
                break;
            cur = tree[cur].link;
        }

        // If palindrome already exists
        if (tree[cur].next[ch - 'a'] != 0) {
            last = tree[cur].next[ch - 'a'];
            return;
        }

        // Create new palindrome node
        Node newNode = new Node(tree[cur].len + 2);
        tree[size] = newNode;
        tree[cur].next[ch - 'a'] = size;

        // Set suffix link
        if (newNode.len == 1) {
            newNode.link = 1;
        } else {
            while (true) {
                cur = tree[cur].link;
                int curLen = tree[cur].len;
                if (pos - 1 - curLen >= 0 && s.charAt(pos - 1 - curLen) == ch) {
                    newNode.link = tree[cur].next[ch - 'a'];
                    break;
                }
            }
        }

        last = size++;

        // Update longest palindrome
        if (newNode.len > maxLen) {
            maxLen = newNode.len;
            endPos = pos;
        }
    }
}