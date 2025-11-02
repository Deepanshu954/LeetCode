class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length;
        int ans = 0;

        for(int i = 0; i < right; i++)
        {
            for(int j = i; j < right; j++)
            {
                int a = (j - i) * Math.min(height[i], height[j]);
                ans = Math.max(a, ans);
            }
        }

        return ans;
    }
}