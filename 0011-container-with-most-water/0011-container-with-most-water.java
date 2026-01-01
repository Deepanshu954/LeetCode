class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            
            // Manual calculation of area to avoid extra method calls
            int h = (hLeft < hRight) ? hLeft : hRight;
            int currentArea = h * (right - left);
            
            if (currentArea > max) {
                max = currentArea;
            }

            // Move the pointer pointing to the shorter bar
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}