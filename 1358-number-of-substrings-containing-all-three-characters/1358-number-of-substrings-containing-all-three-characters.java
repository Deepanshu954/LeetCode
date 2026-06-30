// class Solution {
//     public int numberOfSubstrings(String s) {
//         int count = 0;
//         for(int i=0;i<s.length();i++){
//             int array[] = new int[3];
//             for(int j=i;j<s.length();j++){
//                 char ch = s.charAt(j);
//                 if(ch == 'a' || ch == 'b' || ch == 'c'){
//                     array[ch-'a']++;
//                 }
//                 if(array[0]!=0 && array[1]!=0 && array[2]!=0) count++;
//             }
//         }
//         return count;
//     }
// }
class Solution{
    public int numberOfSubstrings(String s){
        int a = -1,b=-1,c=-1;
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                a = i;
            }
            else if(ch == 'b') b = i;
            else c = i;
            int min = Math.min(a,Math.min(b,c));
            if(min!=-1){
                count+=min+1;
            }
        }
        return count;
    }
}