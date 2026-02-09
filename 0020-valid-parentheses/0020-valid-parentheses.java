class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        for(char a: arr){
            if((a&3)==1){
                if(i==0 || (char)(a-arr[--i])>2) return false;
            }else{
                arr[i++]=a;
            }
        }
        return i==0;
    }
}