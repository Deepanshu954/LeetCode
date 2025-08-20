class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int neg = 1;
        int pos = 0;

        for(int num : nums) {
            if(num >= 0) {
                arr[pos] = num;
                pos += 2;
            } else {
                arr[neg] = num;
                neg += 2;
            }
        }

        return arr;
        
    }
}