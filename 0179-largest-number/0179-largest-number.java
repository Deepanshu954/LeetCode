class Solution {
    public String largestNumber(int[] nums) {

        // Copy Num Array into String Array
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);

        // Sort Array
        Arrays.sort(arr, (a ,b) -> (b + a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";

        // Combing array output into a string
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        
        return sb.toString();
    }
}