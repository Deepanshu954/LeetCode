class Solution {

    private int[] arr;
    public int climbStairs(int n) {
        arr = new int[n+1];
        Arrays.fill(arr, -5);

        return helper(n);
    }

    private int helper(int n) {
        if(n < 2) return 1;
        if(arr[n] != -5) return arr[n];
        return helper(n-1) + helper(n-2);
    }
}

/*
Brute Force: 
Allowed steps are +1 or +2 
so i can use bottom up approach where i come down from up
so here i can create a formula like c(n-1) + c(n-2) this will give me answer 

Code:

class Solution {
    public int climbStairs(int n) {
        if(n < 2) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}



Here i notice that i am calculating for same thing again and again so for that i can simply use a array for stroing things

*/