class Solution {
    public int maxConsecutiveAnswers(String str, int k) {
        int n = str.length();

        int cntT = 0;
        int cntF = 0;
        int max = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {
            if(str.charAt(right) == 'T') cntT++;
            else cntF++;

            while(cntT > k && cntF > k) {
                if(str.charAt(left) == 'T') cntT--;
                else cntF--;

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}