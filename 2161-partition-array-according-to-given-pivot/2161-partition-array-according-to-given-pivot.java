class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        
        int countLessThan = 0;
        int countEqualTo = 0;
        
        // Count frequencies to establish our pointer starting zones
        for (int num : nums) {
            if (num < pivot) {
                countLessThan++;
            } else if (num == pivot) {
                countEqualTo++;
            }
        }
        
        // Establish the 3 pointers mapping to the start of each segment
        int lessThanPointer = 0;
        int equalToPointer = countLessThan;
        int greaterThanPointer = countLessThan + countEqualTo;
        
        // Temporary storage array to map elements correctly in a single pass
        int[] auxiliaryArray = new int[length];
        
        for (int i = 0; i < length; i++) {
            if (nums[i] < pivot) {
                auxiliaryArray[lessThanPointer++] = nums[i];
            } else if (nums[i] == pivot) {
                auxiliaryArray[equalToPointer++] = nums[i];
            } else {
                auxiliaryArray[greaterThanPointer++] = nums[i];
            }
        }
        
        // Copy back to nums to satisfy the in-place modification concept
        System.arraycopy(auxiliaryArray, 0, nums, 0, length);
        
        return nums;
    }
}