class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int index = 1;
        int enc = 1;
        int prev = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            if(enc == 2 && nums[i] == prev) continue;
            else 
            {
                if(nums[i] == prev)
                {
                    enc++;
                    nums[index++] = nums[i];
                }
                else
                {
                    enc = 1;
                    nums[index++] = nums[i];
                    prev = nums[i];
                }
            }
        }
        return index;
    }
}