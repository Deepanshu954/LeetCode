class Solution {
    public String addStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? s2.charAt(j) - '0' : 0;
            
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            
            i--;
            j--;
        }
        
        return sb.reverse().toString();
    }
}