class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while(left < right){
            if(height[left] < height[right])
            {
                if(height[left] >= leftMax) leftMax = height[left];
                else ans += leftMax - height[left];
                left++;
            }
            else
            {
                if(height[right] >= rightMax) rightMax = height[right];
                else ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
        

        // while (n > 0 && height[n - 1] > height[n]) n--;
        // while (left < n && height[left] > height[left + 1]) left++;
        // if (left == n) return 0;


        // for(int right = left; right < n; right++){

        //     rightMax = height[right];
        //     int minHeight = Math.min(leftMax, rightMax);

        //     if(rightMax < leftMax)
            
        //     while(left != right){
        //         ans = minHeight - height[left];
        //         left++;
        //     }
        // }

        
        
    }
}