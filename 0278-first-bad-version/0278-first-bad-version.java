/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int ans = 0;
        
        while (left <= right) {
            // Corrected mid calculation
            int mid = left + (right - left) / 2; 
            
            if (isBadVersion(mid)) {
                ans = mid;       // Record potential first bad version
                right = mid - 1; // Search the left half for an earlier bad version
            } else {
                left = mid + 1;  // Search the right half
            }
        }
        
        return ans;
    }
}