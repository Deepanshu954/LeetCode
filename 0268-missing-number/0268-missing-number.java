class Solution {
    public int missingNumber(int[] nums) 
    {
        int n = nums.length, sum = 0;
        int reqSum = n * (n+1)/2;
        for(int num : nums) sum += num;

        return reqSum - sum;
    }
}

// class Solution {
//     public int missingNumber(int[] nums) 
//     {
//         int n = nums.length;
//         // Set<Integer> s = new HashSet<>();
        
//         // for(int a : arr) {
//         //     s.add(a);
//         // }

//         // //// Using Bubble Sort
//         // // for(int i = 0; i < n; i++) {
//         // //     for(int j = 0; j < n - 1; j++) {
//         // //         if(arr[j] > arr[j+1]) {
//         // //             int temp = arr[j];
//         // //             arr[j] = arr[j+1];
//         // //             arr[j+1] = temp;
//         // //         }
//         // //     }
//         // // }

//         // //// Using sort function of Arrays
//         // // Arrays.sort(arr);

//         // for(int i = 0; i < n; i++) {
//         //     // if(arr[i] != i) return i;
//         //     if(s.contains(i) == false) return i;
//         // }

//         int sum = 0;
//         int reqSum = n * (n+1)/2;
//         for(int num : nums) {
//             sum += num;
//         }


//         return reqSum - sum;
//     }
// }