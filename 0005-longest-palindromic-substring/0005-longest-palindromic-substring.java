class Solution {

    static class Node {
        int len;                     // palindrome length
        int link;                    // suffix link
        java.util.HashMap<Character, Integer> next = new java.util.HashMap<>();
        Node(int l) { len = l; }
    }

    Node[] tree;
    int size, last;
    String s;
    int maxLen = 0, endPos = 0;

    public String longestPalindrome(String str) {
        init();
        s = "";

        for (int i = 0; i < str.length(); i++) {
            addChar(str.charAt(i), i);
        }

        return str.substring(endPos - maxLen + 1, endPos + 1);
    }

    private void init() {
        tree = new Node[1000];
        tree[0] = new Node(-1);   // imaginary root
        tree[1] = new Node(0);    // empty string root
        tree[0].link = 0;
        tree[1].link = 0;
        size = 2;
        last = 1;
    }

    private void addChar(char ch, int pos) {
        s += ch;
        int cur = last;

        // Find extendable suffix palindrome
        while (true) {
            int curLen = tree[cur].len;
            if (pos - 1 - curLen >= 0 && s.charAt(pos - 1 - curLen) == ch)
                break;
            cur = tree[cur].link;
        }

        // If palindrome already exists
        if (tree[cur].next.containsKey(ch)) {
            last = tree[cur].next.get(ch);
            return;
        }

        // Create new node
        Node nn = new Node(tree[cur].len + 2);
        tree[size] = nn;
        tree[cur].next.put(ch, size);

        // Set suffix link
        if (nn.len == 1) {
            nn.link = 1;
        } else {
            while (true) {
                cur = tree[cur].link;
                int curLen = tree[cur].len;
                if (pos - 1 - curLen >= 0 && s.charAt(pos - 1 - curLen) == ch) {
                    nn.link = tree[cur].next.get(ch);
                    break;
                }
            }
        }

        last = size++;

        // Track longest palindrome
        if (nn.len > maxLen) {
            maxLen = nn.len;
            endPos = pos;
        }
    }
}