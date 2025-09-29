class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0, prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int num : nums){
            prefixSum += num;
            
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        }

        return count;

        // int i = 0;
        // for(int j = 1; j < n; j++){

        //     if(sum  == k)
        //     {
        //         cnt++;
        //         max = Math.max(max,cnt);
        //         sum -= nums[i];
        //         i++;
        //     }
        //     else if(sum > k)
        //     {
        //         sum -= nums[i];
        //         i++;
        //     }
        //     else
        //     {
        //         sum += nums[j];
        //     }

        // }

        // return max;
        
    }
}