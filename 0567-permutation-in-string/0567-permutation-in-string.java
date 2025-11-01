class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int window = s1.length();
        int size = s2.length();

        int arr1[] = new int[26];
        int arr2[] = new int[26];

        for (char c : s1.toCharArray())
            arr1[c - 'a']++;

        for (int i = 0; i < window; i++)
            arr2[s2.charAt(i) - 'a']++;

        if (Arrays.equals(arr1, arr2))
            return true;

        for (int i = window; i < size; i++) {
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i - window) - 'a']--;

            if (Arrays.equals(arr1, arr2))
                return true;
        }

        return false;
    }
}