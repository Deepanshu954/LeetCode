// import java.util.Arrays;

// class Solution {
//     public long maxAlternatingSum(int[] nums) {
//         int n = nums.length;
//         long[] squares = new long[n];
        
//         for (int i = 0; i < n; i++) {
//             squares[i] = (long) nums[i] * nums[i];
//         }
        
//         Arrays.sort(squares);
        
//         int size = n / 2;
//         long totalSum = 0;
        
//         for (int i = 0; i < size; i++) {
//             totalSum -= squares[i];
//         }
        
//         for (int i = size; i < n; i++) {
//             totalSum += squares[i];
//         }
        
//         return totalSum;
//     }
// }


import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        Arrays.sort(nums);
        
        int size = n / 2;
        long sum = 0;
        
        for (int i = 0; i < size; i++) {
            sum -= nums[i];
        }
        
        for (int i = size; i < n; i++) {
            sum += nums[i];
        }
        
        return sum;
    }
}