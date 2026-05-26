class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] arr1 = new boolean[26];
        boolean[] arr2 = new boolean[26];

        for(char ch : word.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                arr1[ch - 'a'] = true;
            } else {
                arr2[ch - 'A'] = true;
            }
        }

        int cnt = 0;

        for(int i = 0; i < 26; i++) {
            if(arr1[i] && arr2[i]) cnt++;
        }


        return cnt;
    }
}