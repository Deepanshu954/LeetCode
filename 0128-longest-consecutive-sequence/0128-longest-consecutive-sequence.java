public class Solution {
    public int longestConsecutive(int[] nums) {
int n=nums.length;
int curr=1;
int longest=1;
Arrays.sort(nums);

if(n==0)
return 0;

for(int i=1;i<nums.length;i++)
{
    if(nums[i]==nums[i-1]) continue;
    if(nums[i]==nums[i-1]+1)
    {
        longest++;
    }
    else
    {
        longest=1;
    }
    curr=Math.max(curr,longest);

}
return curr;
    }
}