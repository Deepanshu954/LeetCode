import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        // Step 1: Track frequencies of each element
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }
        
        // Step 2: Handle special base case for '1'
        int ans = 1; // Any single element itself forms a valid subset of length 1
        if (countMap.containsKey(1)) {
            int countOne = countMap.get(1);
            // If the count of 1 is even, we can only use an odd subset size
            if (countOne % 2 == 0) {
                ans = Math.max(ans, countOne - 1);
            } else {
                ans = Math.max(ans, countOne);
            }
        }
        
        // Step 3: Check sequences for bases x > 1
        for (int num : countMap.keySet()) {
            if (num == 1) continue;
            
            int currentLength = 0;
            long x = num; // Use long to prevent integer overflow during squaring
            
            // While we have at least 2 copies of the current power, it can flank both sides
            while (x <= maxNum && countMap.containsKey((int) x) && countMap.get((int) x) >= 2) {
                currentLength += 2;
                x = x * x; // Go to the next power (x^2, x^4, x^8...)
            }
            
            // Determine if the terminating element 'x' can be the peak element
            if (x <= maxNum && countMap.containsKey((int) x) && countMap.get((int) x) >= 1) {
                // If it exists at least once, it can be the single middle element
                ans = Math.max(ans, currentLength + 1);
            } else {
                // If it doesn't exist, the previous element must become the single middle peak element
                // Since we already added 2 for the previous element, we drop one copy to make it the peak
                ans = Math.max(ans, currentLength - 1);
            }
        }
        
        return ans;
    }
}
