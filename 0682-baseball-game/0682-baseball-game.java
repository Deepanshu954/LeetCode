class Solution {
    public int calPoints(String[] operations) {
        List<Integer> arr = new ArrayList<>();

        for (String s : operations) {
            int n = arr.size();

            if (s.equals("+")) {
                arr.add(arr.get(n - 1) + arr.get(n - 2));
            } else if (s.equals("C")) {
                arr.remove(n - 1);
            } else if (s.equals("D")) {
                arr.add(arr.get(n - 1) * 2);
            } else {
                arr.add(Integer.parseInt(s));
            }
        }

        int ans = 0;
        for (int score : arr) {
            ans += score;
        }

        return ans;
    }
}