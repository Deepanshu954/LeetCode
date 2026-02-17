// // Brute Force

// class Solution {
//     public int fib(int n) {
//         if(n < 2) return n;
//         return fib(n-1) + fib(n-2);
//     }
// }

// // Optimal Approach : Using HashMap

// class Solution {
//     private Map<Integer, Integer> map = new HashMap<>();

//     public int fib(int n) {
//         if(n < 2) return n;
        
//         if(map.containsKey(n)) return map.get(n);

//         int result = fib(n-1) + fib(n-2);
//         map.put(n, result);

//         return result;
//     }

// }

// Optimal Approach : Using Array

class Solution {
    public int fib(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        return helper(arr, n);
    }

    private int helper(int[] arr, int n) {
        if( n < 2) return n;

        if(arr[n] != -1) return arr[n];

        arr[n] = helper(arr, n - 1) + helper(arr, n - 2);
        return arr[n];
    }
}