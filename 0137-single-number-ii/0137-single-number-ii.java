class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {          // for each bit
            int cnt = 0;
            for (int n : nums) {
                cnt += (n >> i) & 1;           // count i-th bit
            }
            if (cnt % 3 != 0) {                // leftover bit belongs to answer
                ans |= (1 << i);
            }
        }
        return ans;
    }
}