class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        
        for (int i = 0; i < patterns.length; i++) {
            String pat = patterns[i];
            
            // Check every possible starting position in 'word' for this pattern
            for (int idx = 0; idx <= word.length() - pat.length(); idx++) {
                if (word.startsWith(pat, idx)) {
                    cnt++;
                    break; // Found it! Move to the next pattern.
                }
            }
        }
        
        return cnt;
    }
}
