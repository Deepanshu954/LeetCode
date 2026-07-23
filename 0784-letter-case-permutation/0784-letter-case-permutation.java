public class Solution
{
    private List<String> list;
    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        helper(sb, 0);
        
        return list;
    }
    
    private void helper(StringBuilder sb, int idx) {
        if(idx == sb.length()) {
            list.add(sb.toString());
            return;
        }
        
        if(Character.isDigit(sb.charAt(idx))) {
            helper(sb, idx + 1);
            return;
        }
        
        // lowercase
        sb.setCharAt(idx, Character.toLowerCase(sb.charAt(idx)));
        helper(sb, idx+1);
        
        // upercase
        sb.setCharAt(idx, Character.toUpperCase(sb.charAt(idx)));
        helper(sb, idx+1);
    }
}