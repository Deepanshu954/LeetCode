class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        // for(int i = 0; i < right; i++)
        // {
        //     for(int j = i; j < right; j++)
        //     {
        //         int a = (j - i) * Math.min(height[i], height[j]);
        //         ans = Math.max(a, ans);
        //     }
        // }

        
        while(left < right){
            int min = Math.min(height[left], height[right]);
            max = Math.max(min * (right - left),max);



            if(height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}