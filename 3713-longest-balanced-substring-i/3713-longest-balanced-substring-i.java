class Solution {
    public int longestBalanced(String s) {

        int res = Integer.MIN_VALUE;
        int arr[] = new int[26];
        for(int i=0;i<s.length();i++){
          Arrays.fill(arr,0);
          for(int j=i;j<s.length();j++){
            arr[s.charAt(j)-'a']++;
            if(func(arr)){
                res = Math.max(res,j-i+1);
            }
          }
        }
        return res;
    }

    public static boolean func(int[] arr){
        int common = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) continue;
            if(common==0){
                common = arr[i];
            }
            else if(common!=arr[i]){
                return false;
            }
        }
        return true;
    }
}