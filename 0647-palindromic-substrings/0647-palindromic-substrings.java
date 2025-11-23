class Solution {

    boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        if(left == right) return true;

        while(left <= right){
            if(str.charAt(left) != str.charAt(right))
                return false;

            left++; right--;
        }

        return true;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                String sub = s.substring(i,j);
                if(isPalindrome(sub)) cnt++;
            }
        }
        return cnt;
    }
}