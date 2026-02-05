class Solution {
    public int maxArea(int[] height) {
        
        int max = -1;
        int min = 0;

        for(int i = 0; i < height.length; i++) {

            int localMax = 0;

            for(int j = i + 1; j < height.length; j++) {

                if(height[i] < height[j]) min = height[i];
                else min = height[j];

                localMax = min * (j - i);

                if(localMax > max) max = localMax;
            }
        }

        return max;
    }
}