class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void helper(int index, int n,int sum ,List<Integer> curr, List<List<Integer>> result) {
        if(curr.size() == n && sum == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() >= n) return;

        for(int i = index; i <= 9; i++) {
            curr.add(i);
            helper(i+1, n, sum - i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}