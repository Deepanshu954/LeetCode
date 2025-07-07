class Solution {
public:
    void sortColors(vector<int>& nums) 
    {
        int count0{0}, count1{0}, count2{0};
        int n = nums.size();

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
            else if(nums[i] == 2) count2++;
            else return;
        }
        int i = 0;
        while(count0--) nums[i++] = 0;
        while(count1--) nums[i++] = 1;
        while(count2--) nums[i++] = 2;
    }
};