class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for(int i = 0; i < tiles.length(); i++) {
            freq[tiles.charAt(i) - 'A']++;
        }

        return dfs(freq);
    }

    private int dfs(int[] freq) {
        int cnt = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;

            freq[i]--;
            cnt += ( dfs(freq) + 1 );
            freq[i]++;
        }

        return cnt;
    }
}