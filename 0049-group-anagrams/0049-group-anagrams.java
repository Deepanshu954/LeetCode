// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {

//         // Map<String, List<String>> map = new HashMap<>();

//         // for(String s : strs)
//         // {
//         //     int[] freq = new int[26];
//         //     for(char ch : s.toCharArray()) freq[ch - 'a']++;

//         //     String key = Arrays.toString(freq);

//         //     map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

//         // }

//         // return new ArrayList<>(map.values());

//         Map<String, List<String>> map = new HashMap<>();

//         for(String s : strs){
//             int[] freq = new int[26];
//             for(char ch : s.toCharArray()) freq[ch - 'a']++;

//             String key = Arrays.toString(freq);

//             map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
//         }

//         return new ArrayList<>(map.values());
        
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}