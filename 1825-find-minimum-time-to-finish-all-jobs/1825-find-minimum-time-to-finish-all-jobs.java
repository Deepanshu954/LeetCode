class Solution {
    public static int minimumTimeRequired(int[] jobs, int k) {
        int sum = 0;
        int max = 0;
        for (int job : jobs) {
            sum += job;
            max = Math.max(max, job);
        }
        
        // Sort descending to optimize backtracking (fail faster on large jobs)
        Arrays.sort(jobs);
        for(int i = 0; i < jobs.length / 2; i++){
            int temp = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = temp;
        }

        int low = max, high = sum;
        int result = sum;
        
        // Binary Search the optimal max load
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] workers = new int[k];
            
            if (canDistribute(jobs, workers, mid, 0)) {
                result = mid;
                high = mid - 1; // Try to find a smaller max load
            } else {
                low = mid + 1;  // Increase the allowed load
            }
        }
        return result;
    }
    
    private static boolean canDistribute(int[] jobs, int[] workers, int limit, int index) {
        // All jobs successfully distributed
        if (index == jobs.length) return true; 
        
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] + jobs[index] <= limit) {
                workers[i] += jobs[index];
                if (canDistribute(jobs, workers, limit, index + 1)) return true;
                workers[i] -= jobs[index]; // Backtrack
            }
            if (workers[i] == 0) break;
        }
        return false;
    }
}