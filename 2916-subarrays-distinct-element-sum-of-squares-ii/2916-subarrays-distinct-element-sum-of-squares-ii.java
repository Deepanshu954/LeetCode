import java.util.*;
class Solution {
    long[] sum;
    long[] sumSquares;
    long[] lazy;
    public int sumCounts(int[] nums) {

        int n = nums.length;
        sum = new long[4*n];
        sumSquares = new long[4*n];
        lazy = new long[4*n];

        int MOD = 1_000_000_007;
        long answer = 0;

        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i);
            answer = (answer + sumSquares[1]) % MOD;
            lastSeen.put(nums[i], i);
        }
        return (int) answer;  
        
    }

    private void update(int node, int start, int end, int L, int R ){
        if(start > R || end < L){
            return;
        }else if(L <= start && end <= R){
            long k = end - start + 1;
            long oldSum = sum[node];
            sumSquares[node] += 2 * oldSum + k;
            sum[node] += k;
            lazy[node]++;
            return;
        }else{
            int mid = start + (end - start) / 2;

            pushDown(node, start, end);

            update(2 * node, start, mid, L, R);
            update(2 * node + 1, mid + 1, end, L, R);

            sum[node] = sum[2 * node] + sum[2 * node + 1];
            sumSquares[node] = sumSquares[2 * node] + sumSquares[2 * node + 1];
            
        }
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
            }

        int mid = start + (end - start) / 2;
        long v = lazy[node];

        int left = 2 * node;
        int right = 2 * node + 1;

        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        long oldLeftSum = sum[left];

        sumSquares[left] += 2 * v * oldLeftSum+ v * v * leftLen;
        sum[left] += v * leftLen;

        lazy[left] += v;

        long oldRightSum = sum[right];

        sumSquares[right] += 2 * v * oldRightSum + v * v * rightLen;
        sum[right] += v * rightLen;
        lazy[right] += v;

        lazy[node] = 0;
        }
}