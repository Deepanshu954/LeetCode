class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                // Bug Fix 1: Only delete if the StringBuilder is not empty
                if (sb1.length() > 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                // Bug Fix 2: Use .append() instead of .add()
                sb1.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                // Bug Fix 1: Only delete if the StringBuilder is not empty
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                // Bug Fix 2: Use .append() instead of .add()
                sb2.append(t.charAt(i));
            }
        }

        // Bug Fix 3: Compare string content instead of memory references
        return sb1.toString().equals(sb2.toString());
    }
}
