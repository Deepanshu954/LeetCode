class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num * 9 < sum) return "";

        StringBuilder sb = new StringBuilder();

        int currSum = 0;
        for(int i = 0; i < num; i++) {
            int diff = sum - currSum;

            if(diff == 0) {
                sb.append(0);
            }
            else if(diff <= 9) {
                sb.append(diff);
                currSum += diff;
            } else {
                sb.append(9);
                currSum += 9;
            }
        }

        return sb.toString();
    }
}