class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> s = new HashSet<>();

        for(int num : nums) {
            if(!set.add(num)) s.add(num);
        }

        List<Integer> list = new ArrayList<>();

        for(int i : s) list.add(i);
        return list;
    }
}