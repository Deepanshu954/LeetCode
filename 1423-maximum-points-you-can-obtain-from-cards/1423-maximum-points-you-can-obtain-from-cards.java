class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currentSum = 0;

        // Start by taking all k cards from the left
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }

        int maxScore = currentSum;

        // "Move" the window: remove one from the left, add one from the right
        for (int i = 0; i < k; i++) {
            currentSum -= cardPoints[k - 1 - i]; // Remove from left
            currentSum += cardPoints[n - 1 - i]; // Add from right
            maxScore = Math.max(maxScore, currentSum);
        }

        return maxScore;
    }
}