class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        helper(digits, 0, "", map, result);
        return result;
    }

    private void helper(String digits, int index, String temp,
                        HashMap<Character, String> map,
                        List<String> result) {

        if (index == digits.length()) {
            result.add(temp);
            return;
        }

        char ch = digits.charAt(index);
        String letters = map.get(ch);

        for (int i = 0; i < letters.length(); i++) {
            helper(digits, index + 1,
                   temp + letters.charAt(i),
                   map, result);
        }
    }
}