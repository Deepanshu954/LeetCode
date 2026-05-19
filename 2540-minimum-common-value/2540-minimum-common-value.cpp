class Solution {
public:

    // Standard binary search
    bool find(int target, vector<int>& nums2){
        int left = 0, right = nums2.size() - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums2[mid] < target)
                left = mid + 1;
            else if(nums2[mid] > target)
                right = mid - 1;
            else
                return true;   // target found
        }
        return false;
    }

    int getCommon(vector<int>& nums1, vector<int>& nums2) {

        // Try every element of nums1
        for(int i = 0; i < nums1.size(); i++){
            if(find(nums1[i], nums2))
                return nums1[i];   // first common element
        }

        return -1;
    }
};