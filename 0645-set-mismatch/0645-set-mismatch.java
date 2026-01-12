class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[2];

        for(int num : nums){
            if(!set.add(num)) arr[0] = num;
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i+1)){
                arr[1] = i + 1;
                return arr;
            }
        }

        return arr;
    }
}