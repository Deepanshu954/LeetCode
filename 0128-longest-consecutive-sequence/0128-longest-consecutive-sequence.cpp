class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> numSet(nums.begin(), nums.end());
        int maxStreak = 0;

        for(int num : numSet) {
            if(!numSet.count(num - 1)) { // Only start from sequence start
                int currNum = num;
                int currStreak = 1;

                while(numSet.count(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                maxStreak = max(maxStreak, currStreak);
            }
        }

        return maxStreak;
    }
};