class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int t0 = 0;
        int t1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') t0++;
            else t1++;
        }

        int[] first = new int[2*n + 1];
        int[] second = new int[2*n + 1];
        Arrays.fill(first, -2);
        Arrays.fill(second, -2);

        int sum = 0;
        int offset = n;
        first[offset] = -1;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '1') ? 1 : -1;

            if(first[sum + offset] != -2) {
                ans = Math.max(ans, i - first[sum + offset]);
            }

            int target1 = sum - 2 + offset;
            if(target1 >= 0 && target1 <= 2 * n) {
                int j1 = first[target1];
                if(j1 != -2) {
                    int len = i -j1;
                    if(t0 >= len/2) ans = Math.max(ans, len);
                    else {
                        int j2 = second[target1];
                        if(j2 != -2) {
                            int len2 = i - j2;
                            if(t0 >= len2/2) ans = Math.max(ans, len2);
                        }
                    }
                }
            }


            int target2 = sum + 2 + offset;
            if(target2 >= 0 && target2 <= 2 * n) {
                int j1 = first[target2];
                
                if(j1 != -2) {
                    int len = i -j1;
                    if(t1 >= len/2) ans = Math.max(ans, len);
                    else {
                        int j2 = second[target2];
                        if(j2 != -2) {
                            int len2 = i - j2;
                            if(t1 >= len2/2) ans = Math.max(ans, len2);
                        }
                    }
                }
            }

            if(first[sum + offset] == -2) first[sum + offset] = i;
            else if(second[sum + offset] == -2) second[sum + offset] = i;
            
        }

        return ans;
    }
}



















