class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int left = 0;
        for(int i = 1; i <= 2000; i++) {
            if(left < n && arr[left] == i) left++;
            else k--;

            if(k == 0) return i;
        }

        return -1;
    }
}