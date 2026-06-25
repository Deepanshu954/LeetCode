class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        int currentPrefixSum = 0;
        
        // Offset by n + 1 to handle negative prefix sums (array indices must be > 0)
        int offset = n + 1; 
        FenwickTree bit = new FenwickTree(2 * n + 2);
        
        // Add the initial prefix sum of 0 (with offset)
        bit.update(0 + offset, 1);
        
        for (int num : nums) {
            currentPrefixSum += (num == target) ? 1 : -1;
            
            // We want to find how many previous prefix sums are strictly less than currentPrefixSum
            // So we query the BIT for everything up to currentPrefixSum - 1
            res += bit.query(currentPrefixSum - 1 + offset);
            
            // Add the current prefix sum to our BIT
            bit.update(currentPrefixSum + offset, 1);
        }
        
        return res;
    }
}

// OOPS concept: Encapsulating the BIT logic
class FenwickTree {
    private int[] tree;
    
    public FenwickTree(int size) {
        tree = new int[size];
    }
    
    public void update(int index, int delta) {
        for (; index < tree.length; index += index & (-index)) {
            tree[index] += delta;
        }
    }
    
    public int query(int index) {
        int sum = 0;
        for (; index > 0; index -= index & (-index)) {
            sum += tree[index];
        }
        return sum;
    }
}