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
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, map, result);
        return result;
    }

    private void helper(String digits, int index, StringBuilder sb,HashMap<Character, String> map, List<String> result) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(index);
        String str = map.get(ch);

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            helper(digits, index + 1,sb, map, result);
            sb.setLength(sb.length() - 1);
        }
    }
}