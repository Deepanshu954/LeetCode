class Solution {
    private int mod = (int)1e9;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for(int x : nums) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;
        k = k/2;

        int[] dp = new int[k+1];

        // Base Case
        dp[0] = (nums[0] == 0) ? 2 : 1;

        if(nums[0] != 0 && nums[0] <= k) dp[nums[0]] = 1;

        // rest
        for(int i = 1; i < n; i++) {
            for(int j = k; j >= nums[i]; j--) {
                int notTake = dp[j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[j - nums[i]];
                }

                dp[j] = (take + notTake) % mod;
            }
        }
        
        return dp[k];
    }
}

/*
// Space Optimzation

import java.util.* ;
import java.io.*; 
public class Solution {
    private static int[][] dp;
    private static int mod = (int)1e9;

    public static int targetSum(int n, int target, int[] nums) {
        int total = 0;
        for(int x : nums) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;
        k = k/2;

        int[] dp = new int[k+1];

        // Base Case
        dp[0] = (nums[0] == 0) ? 2 : 1;

        if(nums[0] != 0 && nums[0] <= k) dp[nums[0]] = 1;

        // rest
        for(int i = 1; i < n; i++) {
            for(int j = k; j >= nums[i]; j--) {
                int notTake = dp[j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[j - nums[i]];
                }

                dp[j] = (take + notTake) % mod;
            }
        }
        
        return dp[k];
    }
}

*/

/*

// recursion

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	// Write your code here.
        int total = 0;
        for(int x : arr) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;

        return rec(n-1, k/2, arr);
    }

    private static int rec(int i, int k, int[] nums) {
        if(i == 0) {
            if(k == 0 && nums[0] == 0) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }

        int notTake = rec(i-1, k, nums);

        int take = 0;
        if(nums[i] <= k) {
            take = rec(i-1, k - nums[i], nums);
        }

        return take + notTake;
    }
}

*/

/*

// Memorization


import java.util.* ;
import java.io.*; 
public class Solution {
    private static int[][] dp;

    public static int targetSum(int n, int target, int[] arr) {
        int total = 0;
        for(int x : arr) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;

        dp = new int[n][k+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(n-1, k/2, arr);
    }

    private static int rec(int i, int k, int[] nums) {
        if(i == 0) {
            if(k == 0 && nums[0] == 0) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }

        if(dp[i][k] != -1) return dp[i][k];

        int notTake = rec(i-1, k, nums);

        int take = 0;
        if(nums[i] <= k) {
            take = rec(i-1, k - nums[i], nums);
        }

        return dp[i][k] = take + notTake;
    }
}

*/

/*

// Tabular

import java.util.* ;
import java.io.*; 
public class Solution {
    private static int[][] dp;
    private static int mod = (int)1e9;

    public static int targetSum(int n, int target, int[] nums) {
        int total = 0;
        for(int x : nums) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;
        k = k/2;

        int[][] dp = new int[n][k+1];

        // Base Case
        dp[0][0] = (nums[0] == 0) ? 2 : 1;

        if(nums[0] != 0 && nums[0] <= k) dp[0][nums[0]] = 1;

        // rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int notTake = dp[i-1][j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[i-1][j - nums[i]];
                }

                dp[i][j] = (take + notTake) % mod;
            }
        }
        
        return dp[n-1][k];
    }
}


*/