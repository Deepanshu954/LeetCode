class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Long, Integer> mpp = new HashMap<>();
        int ans = (int)1e6;
        
        for(int i=0; i<n; i++){
            long num = (long)nums[i];
            if(mpp.containsKey(num)){
                ans = Math.min(ans, i - mpp.get(num));
            }

            long temp = reverseNum(num);
            mpp.put(temp, i);
        }

        return ans == (int)1e6 ? -1 : ans;
    }

    private long reverseNum(long num){
        long res = 0;

        while(num > 0){
            res *= 10;
            res += (num % 10);
            
            num /= 10;
        }

        return res;
    }
}