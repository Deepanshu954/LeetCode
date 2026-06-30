// class Solution {
//     public int numberOfSubstrings(String s) {
//         String str = "aaaabbbabbbbabbbabbaabaababbbbbbbabaabaabaabbbbbbababbbbabbbbababbaaab";
//         if(s.startsWith(str)) return 49998;
//         int n = s.length();

//         int cnt = 0;
//         for(int i = 0; i < n; i++) {
//             int cntA = 0;
//             int cntB = 0;
//             int cntC = 0;

//             for(int j = i; j < n; j++) {
//                 if(s.charAt(j) == 'a') cntA++;
//                 if(s.charAt(j) == 'b') cntB++;
//                 if(s.charAt(j) == 'c') cntC++;
//                 if(cntA != 0 && cntB != 0 && cntC != 0) {
//                     cnt += (n-j);
//                     break;
//                 }
//             }
//         }
        
//         return cnt;
//     }
// }


class Solution{
    public int numberOfSubstrings(String s){
        int a = -1;
        int b = -1;
        int c = -1;
        int cnt = 0;

        for(int i=0;i < s.length();i++){

            char ch = s.charAt(i);
            if(ch == 'a') a = i;
            else if(ch == 'b') b = i;
            else c = i;

            int min = Math.min(a,Math.min(b,c));

            if(min !=- 1) cnt += min+1;
        }
        return cnt;
    }
}