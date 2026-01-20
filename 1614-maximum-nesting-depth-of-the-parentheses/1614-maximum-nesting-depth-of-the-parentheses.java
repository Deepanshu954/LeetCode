class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')')count--;
            else continue;

            if(max < count) max = count;
            
        }
        return max;
    }
}