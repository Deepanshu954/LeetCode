class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        // for(int i = 0; i < right; i++)
        // {
        //     for(int j = i; j < right; j++)
        //     {
        //         int a = (j - i) * Math.min(height[i], height[j]);
        //         ans = Math.max(a, ans);
        //     }
        // }

        
        while(left < right){

            int a = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(a, ans);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return ans;
    }
}