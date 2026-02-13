class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length - 1;
        int sum = 0;

        int index = k;

        while(left <= right && index > 0) {
            if(cardPoints[left] == cardPoints[right]) {
                if(cardPoints[left + 1] < cardPoints[right - 1]) sum += cardPoints[right--];
                else sum += cardPoints[left++];
            }
            else if(cardPoints[left] < cardPoints[right]) sum += cardPoints[right--];
            else sum += cardPoints[left++];

            index--;
        } 

        return sum;
    }
}