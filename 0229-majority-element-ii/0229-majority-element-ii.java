class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int num2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num1) cnt1++;
            else if(nums[i] == num2) cnt2++;
            else {
                if(cnt1 == 0) {
                    num1 = nums[i];
                    cnt1 = 1;
                } else if(cnt2 == 0) {
                    num2 = nums[i];
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
        }

        int c1 = 0;
        int c2 = 0;

        for(int num : nums) {
            if(num == num1) c1++;
            else if(num == num2) c2++;
        }

        List<Integer> list = new ArrayList<>();

        if(c1 * 3 > n) list.add(num1);
        if(c2 * 3 > n) list.add(num2);

        return list;
    }
}