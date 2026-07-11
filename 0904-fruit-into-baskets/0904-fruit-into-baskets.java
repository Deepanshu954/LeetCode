public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        
        int t1 = fruits[0]; // Fruit 1
        int t2 = -1; // Fruit 2
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int maxLen = 0;
        
        int left = 0;
        for(int right = 0; right < n; right++) {
            if(fruits[right] == t1) cnt1++;
            else if(fruits[right] == t2) cnt2++;
            else if(t2 == -1) {
                t2 = fruits[right];
                cnt2 = 1;
            } else {
                while(cnt1 > 0 && cnt2 > 0) {
                    if(fruits[left] == t1) cnt1--;
                    else cnt2--;
                    
                    left++;
                }
                
                if(cnt1 == 0) {
                    cnt1 = 1;
                    t1 = fruits[right];
                } else {
                    cnt2 = 1;
                    t2 = fruits[right];
                }
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;  
    }
}