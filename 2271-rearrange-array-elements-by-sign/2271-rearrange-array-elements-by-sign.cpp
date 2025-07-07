class Solution {
    public:
    vector<int> rearrangeArray(vector<int>& nums)
    {
        int n = nums.size();
        vector<int> arr(n);

        int j{0}, k{1};
        for(int i = 0; i < n; i++)
        {
            if(nums[i] >= 0)
            {
                arr[j] = nums[i];
                j = j+2;
            }
            else
            {
                arr[k] = nums[i];
                k = k+2;
            }
        }

        return arr;
    }

/*
public:
    vector<int> rearrangeArray(vector<int>& nums)
    {
        int n = nums.size();

        vector<int> arr1;
        vector<int> arr2;
        vector<int> finalArr;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] > 0)
            {
                arr1.push_back(nums[i]);
            }
            else
            {
                arr2.push_back(nums[i]);
            }
        }

        for(int i = 0; i < n/2; i++)
        {
            finalArr.push_back(arr1[i]);
            finalArr.push_back(arr2[i]);
        }

        return finalArr;
    }
*/
}; 