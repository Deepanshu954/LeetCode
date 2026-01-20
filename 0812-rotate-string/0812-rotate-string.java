class Solution {
    public boolean rotateString(String s, String goal) {

        return (s + s).contains(goal);
        
    }
}


// class Solution {
//     public boolean rotateString(String s, String goal) {

//         StringBuilder sb = new StringBuilder();

//         for(int i = 0; i < s.length(); i++) {
//             String str = s.substring(i, s.length()) + s.substring(0,i);

//             if(str.equals(goal)) return true;
//         }
//         return false;
//     }
// }