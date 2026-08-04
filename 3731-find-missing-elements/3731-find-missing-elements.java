class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        int min = 100;
        int max = 1;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);

            set.add(num);
        }

        for(int i = min; i <= max; i++) {
            if(!set.contains(i)) list.add(i);
        }

        return list;
    }
}