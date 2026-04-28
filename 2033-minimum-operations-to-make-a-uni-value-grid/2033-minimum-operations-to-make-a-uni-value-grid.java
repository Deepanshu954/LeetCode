class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums =  new int[m * n];

        Set<Integer> set = new HashSet<>();

        int idx = 0;
        for(int [] g : grid){
            for(int num : g) {
                nums[idx++] = num;
                set.add(num);
            }
        }

        if(nums.length == 1 || set.size() == 1) return 0;

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;

            int num = nums[mid];
            int ops = 0;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] == num) continue;
                int temp = Math.abs(num - nums[i]);
                if((temp % x) == 0){
                    ops += temp / x;
                }
                else {
                    ops = 0;
                    break;
                }
            }
            if(ops != 0 && ops < min) {
                min = ops;
                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}