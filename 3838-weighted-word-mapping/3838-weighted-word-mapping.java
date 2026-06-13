class Solution {
    public String mapWordWeights(String[] words, int[] w) {
        StringBuilder sb = new StringBuilder();

        for (String str : words) {
            int idx = 0;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                idx += w[ch - 'a'];
            }

            idx = 25 - (idx % 26);
            char c = (char) ('a' + idx);
            sb.append(c);
        }

        return sb.toString();
    }
}