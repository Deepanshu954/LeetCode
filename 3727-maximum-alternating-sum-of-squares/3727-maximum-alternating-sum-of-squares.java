import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squares);
        
        int subtractCount = n / 2;
        long totalSum = 0;
        
        // Smallest n/2 elements are subtracted
        for (int i = 0; i < subtractCount; i++) {
            totalSum -= squares[i];
        }
        
        // Remaining largest elements are added
        for (int i = subtractCount; i < n; i++) {
            totalSum += squares[i];
        }
        
        return totalSum;
    }
}