class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        int n = s.length();
        int cycle = 2 * numRows - 2;

        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < numRows; row++) {

            for(int j = row; j < n; j+= cycle) {
                sb.append(s.charAt(j));

                int diag = j + cycle - 2 * row;

                if(row != 0 && row != numRows - 1 && diag < n) {
                    sb.append(s.charAt(diag));
                }
            }
        }

        return sb.toString();
    }
}