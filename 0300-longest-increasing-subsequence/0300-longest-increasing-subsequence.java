class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            int idx = Collections.binarySearch(list, num);

            if(idx < 0) 
                idx = -(idx + 1);

            if(idx == list.size()) 
                list.add(num);
            else
                list.set(idx, num);
        }

        return list.size();
    }
}




/*

// Recursion

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return rec(n-1, -1,nums);
    }

    private int rec(int i, int prev,int[] nums) {
        if(i < 0) return 0;

        // not take
        int notTake = rec(i-1, prev, nums);

        // take
        int take = 0;
        if(prev == -1 || nums[i] < nums[prev]) {
            take = 1 + rec(i-1, i, nums);
        }

        return Math.max(take, notTake);
    }
}

*/

/*

// Memorization

class Solution {
    private Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new Integer[n+1][n+1];

        return rec(n-1, -1,nums);
    }

    private int rec(int i, int prev,int[] nums) {
        if(i < 0) return 0;

        if(prev != -1 && dp[i][prev] != null) return dp[i][prev];

        // not take
        int notTake = rec(i-1, prev, nums);

        // take
        int take = 0;
        if(prev == -1 || nums[i] < nums[prev]) {
            take = 1 + rec(i-1, i, nums);
        }

        if(prev == -1) 
            return Math.max(take, notTake);
        else
            return dp[i][prev] = Math.max(take, notTake);
    }
}

*/

/*

// Tabular

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--) {
            for(int j = i-1; j >= -1; j--) {

                int notTake = dp[i+1][j+1];

                int take = 0;
                if(j == -1 || nums[i] > nums[j]) {
                    take = 1 + dp[i+1][i+1];
                }

                dp[i][j+1] = Math.max(notTake, take);

            }
        }

        return dp[0][0];
    }
}

*/

/*

// Space Optimization

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--) {

            int[] curr = new int[n+1];
            for(int j = i-1; j >= -1; j--) {

                int notTake = dp[j+1];

                int take = 0;
                if(j == -1 || nums[i] > nums[j]) {
                    take = 1 + dp[i+1];
                }

                curr[j+1] = Math.max(notTake, take);

            }

            dp = curr;
        }

        return dp[0];
    }
}

*/