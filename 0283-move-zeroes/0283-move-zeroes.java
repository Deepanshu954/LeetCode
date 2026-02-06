class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) cnt++;
            else if(i == index) index++;
            else nums[index++] = nums[i];
        }

        while(cnt > 0){
            nums[index++] = 0; cnt--;
        }
        return;
    }
}