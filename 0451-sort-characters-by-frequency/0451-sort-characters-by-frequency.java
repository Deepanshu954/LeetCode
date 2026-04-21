import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        // 1. Create a 2D matrix: 128 rows (for ASCII), 2 columns 
        // Column 0: The character (as int), Column 1: The frequency count
        int[][] nums = new int[128][2];

        // Initialize the character identity in the matrix
        for (int i = 0; i < 128; i++) {
            nums[i][0] = i; 
        }

        // 2. Fill frequencies
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            nums[ch][1]++;
        }

        // 3. Max-Heap (PriorityQueue) to sort by frequency
        // We compare index 1 (frequency) of the 1D arrays (rows)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 128; i++) {
            if (nums[i][1] > 0) {
                pq.add(nums[i]);
            }
        }

        // 4. Build the resulting string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            char c = (char) current[0]; // Type cast int back to char
            int freq = current[1];
            
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}