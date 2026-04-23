class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()) {
            int size = list.size();

            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            for(int i = 1; i < size; i++) {
                prefix[i] = prefix[i-1] + list.get(i);
            }

            for(int i = 0; i < size; i++) {
                long curr = list.get(i);

                long leftSum = (i > 0) ? prefix[i-1] : 0;
                long left = curr * i - leftSum;

                long rightSum = prefix[size-1] - prefix[i];
                long right = rightSum - curr * (size - i - 1);

                res[(int)curr] = left + right;
            }
        }

        return res;
    }
}


/*

// This was first approach...
// This fale due to tle..
// Then i think of range sum query


class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i < n; i++) {
            int val = nums[i];
            List<Integer> indices = map.get(val);
            
            if (indices.size() == 1) {
                res[i] = 0;
                continue;
            }

            long sum = 0;
            for(int indexInList : indices) {
                sum += Math.abs((long)indexInList - i);
            }
            res[i] = sum;
        }

        return res;
    }
}

*/