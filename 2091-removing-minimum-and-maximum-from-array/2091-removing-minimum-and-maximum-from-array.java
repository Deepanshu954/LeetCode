class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        int minIdx = 0;
        int maxIdx = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < nums[minIdx]) minIdx = i;
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        }


        // now we have location of min ele and max ele

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // cover all posibilites
        int front = j + 1;
        int back = n - i;
        int both = (i+1) + (n - j);

        return Math.min(Math.min(front, back), both);

        // int res = 0;

        // res = Math.min( 
        //     Math.min( Math.max(minIdx, maxIdx), Math.max(n - minIdx, n - maxIdx) ),
        //     Math.min( (minIdx + (n- maxIdx)), (maxIdx + (n-minIdx)) )
        // );

        // return res+1;
    }
}











