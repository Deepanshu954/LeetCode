// class Solution {
//     public boolean isAlienSorted(String[] words, String order) {
//         Map<Character, Integer> map = new HashMap<>();

//         for(int i = 0; i < 26; i++){
//             map.put(order.charAt(i), i);
//         }

        

//         for(int j = 0; j < words.length - 1; j++){
//             String word1 = words[j];
//             String word2 = words[j+1];

//             //if(word1.equals("kuvp") && word2.equals("q") return true;

//             if(word1.equals(word2)) continue;

//             int len = Math.min(word1.length(), word2.length());
//             boolean differenceFound = false;

//             for(int i = 0; i < len; i++){
//                 char ch1 = word1.charAt(i);
//                 char ch2 = word2.charAt(i);
                
//                 if(ch1 != ch2){
//                     if(map.get(ch1) > map.get(ch2)) return false;
//                     differenceFound = true;
//                     break;
//                 }
                
//             }
//             if(!differenceFound && word1.length() > word2.length()) return false;
//         }

//         return true;
//     }
// }






class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int arr[] = new int[26];

        for(int i = 0; i < 26; i++){
            //map.put(order.charAt(i), i);
            arr[order.charAt(i) - 'a'] = i;
        }

        

        for(int j = 0; j < words.length - 1; j++){
            String word1 = words[j];
            String word2 = words[j+1];

            //if(word1.equals("kuvp") && word2.equals("q") return true;

            if(word1.equals(word2)) continue;

            int len = Math.min(word1.length(), word2.length());
            boolean differenceFound = false;

            for(int i = 0; i < len; i++){
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(i);
                
                if(ch1 != ch2){
                    if(arr[ch1 - 'a'] > arr[ch2 - 'a']) return false;
                    differenceFound = true;
                    break;
                }
                
            }
            if(!differenceFound && word1.length() > word2.length()) return false;
        }

        return true;
    }
}