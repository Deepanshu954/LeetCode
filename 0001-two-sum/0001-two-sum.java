class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int n = nums.length;
        int arr[] = new int[2];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i != j && nums[i] + nums[j] == target)
                {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }

        return arr;
    }
}