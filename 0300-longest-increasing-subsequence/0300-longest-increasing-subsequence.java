import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        for(int num : nums) {

            int idx = Collections.binarySearch(temp, num);

            if(idx < 0) idx = -(idx + 1); // lower_bound

            if(idx == temp.size()) {
                temp.add(num);
            } else {
                temp.set(idx, num);
            }
        }

        return temp.size();
    }
}