class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        int h = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                h = height[left];
                left++;
            }
            else {
                h = height[right];
                right--;
            }

            maxArea = Math.max(maxArea, h * (right - left + 1));
        }

        return maxArea;
    }
}