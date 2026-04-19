class Solution {
    public int climbStairs(int n) {
        if(n < 2) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

/*
Allowed steps are +1 or +2 
so i can use bottom up approach where i come down from up
so here i can create a formula like c(n-1) + c(n-2) this will give me answer 

*/