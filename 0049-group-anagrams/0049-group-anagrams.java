import java.util.*;

class Solution {
    /**
     * Groups strings in an array into lists of anagrams.
     * Anagrams are grouped by using the sorted version of the string as a map key.
     * * @param strs The input array of strings.
     * @return A list of lists, where each inner list contains a group of anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a HashMap to store the canonical form (sorted string) as the key 
        // and a list of original strings (anagrams) as the value.
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String originalWord : strs) {
            // 1. Convert the string to a character array.
            char[] charArray = originalWord.toCharArray();
            
            // 2. Sort the character array to create the canonical form (O(K log K)).
            Arrays.sort(charArray);
            
            // 3. Convert the sorted character array back to a String.
            // This sorted string is the unique identifier for all its anagrams.
            String canonicalKey = new String(charArray);
            
            // Enhanced Logic: Use computeIfAbsent to simplify the map insertion.
            // This method checks if the key exists; if not, it creates a new ArrayList 
            // and puts it into the map, then returns the list for the add operation.
            anagramGroups
                .computeIfAbsent(canonicalKey, k -> new ArrayList<>())
                .add(originalWord);
        }

        // Return all the grouped lists of strings (the map's values).
        return new ArrayList<>(anagramGroups.values());
    }
}