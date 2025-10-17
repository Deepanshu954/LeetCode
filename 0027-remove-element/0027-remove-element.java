class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt = 0;


        for(int i = 0; i < n - cnt; i++)
        {
            if(nums[i] == val)
            {
                for(int j = i; j < n - 1; j++)
                {
                    nums[j] = nums[j+1];
                }

                cnt++;
                i--;
            }
        }

        return n - cnt;
    }
}