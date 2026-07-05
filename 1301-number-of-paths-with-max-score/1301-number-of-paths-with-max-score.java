class Solution {
    private int res = 0;
    private int cnt = 0;
    private int mod = 1000000007;
    
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.get(0).length() - 1;
        int n = board.size() - 1;

        helper(n, m, 0, board);
        return new int[] {res, cnt};
    }

    private void helper(int row, int col, int sum, List<String> board) {
        if(row == 0 && col == 0) {
            if(sum > res) {
                res = sum;
                cnt = 0;
            }

            if(res == sum) {
                cnt = (cnt + 1) % mod;
            }
            return;
        }

        if(row > 0 && board.get(row-1).charAt(col) != 'X') {
            char c = board.get(row-1).charAt(col);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row - 1, col, sum + val, board);
        }

        if(col > 0 && board.get(row).charAt(col-1) != 'X') {
            char c = board.get(row).charAt(col-1);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row, col - 1, sum + val, board);
        }

        if(row > 0 && col > 0 && board.get(row-1).charAt(col-1) != 'X') {
            char c = board.get(row-1).charAt(col-1);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row - 1, col - 1, sum + val, board);
        }
    } 
}