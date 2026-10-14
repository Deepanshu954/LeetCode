class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num * 9 < sum) return "";
        // if(num == 1) return "";
        int n;

        int[] arr = new int[num];

        int currSum = 0;

        for(int i = 0; i < num; i++) {
            int diff = sum - currSum;

            if(diff == 0) break;
            if(diff <= 9) {
                arr[i] = diff;
                break;
            } else {
                arr[i] = 9;
                currSum += 9;
            }
        }



        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}