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
        arr[n] helper(n-1) + helper(n-2);
        return arr[n];
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

Code: 
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
        arr[n] helper(n-1) + helper(n-2);
        return arr[n];
    }
}

Now my plan is to use interative methord

Code:
class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n + 1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n+1];
    }
}


Btw i notice one more thing here that i need memeory of two varibales for navigate this situation so why even need to use an array...

class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        for(int i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}

*/