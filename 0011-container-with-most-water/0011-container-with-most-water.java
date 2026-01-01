class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            
            int h = (hLeft < hRight) ? hLeft : hRight;
            int currentArea = h * (right - left);
            
            if (currentArea > max) {
                max = currentArea;
            }

            if(hLeft < hRight) left++;
            else right--;
        }
        return max;
    }
}

// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int max = 0;

//         while(left < right){
//             max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

//             if(height[left] <= height[right]) left++;
//             else right--;
//         }
//         return max;
//     }
// }