import java.util.Arrays;

public class Solution{
    
    private int mod = 1000000007;
    public static int maxSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int i = 0;
        int j = 0;
        long sum1 = 0;
        long sum2 = 0;
        long totalScore = 0;
        long mod = 1_000_000_007;
        
        while(i < n1 && j < n2) {

            if(nums1[i] < nums2[j]) sum1 += nums1[i++];
            else if(nums1[i] > nums2[j]) sum2 += nums2[j++];
            else {
                totalScore += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
                
            }
        }
        
        while(i < n1) {
            sum1 += nums1[i++];
        }
        
        while(j < n2) {
            sum2 += nums2[j++];
        }
        
        totalScore += Math.max(sum1, sum2);
        
        return (int) (totalScore % mod);
    }
}