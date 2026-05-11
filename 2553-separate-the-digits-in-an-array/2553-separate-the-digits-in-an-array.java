class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int val=nums[i];
            if(val>=10)
            {
                String num=val+"";
                for(int j=0;j<num.length();j++)
                {
                    char ch=num.charAt(j);
                    list.add(ch-'0');
                }
            }
            else
            {
                list.add(val);
            }
        }
        int arr[]=new int[list.size()];
        int ind=0;
        
        for(int i=0;i<list.size();i++)
        {
            arr[ind++]=list.get(i);
        }
        return arr;
    }
}