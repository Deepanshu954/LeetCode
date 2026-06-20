class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // sorting restrictions according to index.
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int len = restrictions.length + 2;
        int[][] arr = new int[len][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[len-1][0] = n;
        arr[len-1][1] = n-1;
        for(int i = 1; i<len-1; ++i){
            arr[i] = restrictions[i-1];
        }
        
        // looping from left to right
        for(int i = 0; i<len-1; ++i){
            arr[i+1][1] = Math.min(arr[i+1][1], arr[i][1] + (arr[i+1][0] - arr[i][0]));
        }
        
        // looping from right to left
        for(int i = len-1; i>0; --i){
            arr[i-1][1] = Math.min(arr[i-1][1], arr[i][1] + (arr[i][0] - arr[i-1][0]));
        }
        
        int max = 0;
        
        for(int i = 0; i<len-1; ++i){
            int j = arr[i][0], h1 = arr[i][1], k = arr[i+1][0], h2 = arr[i+1][1];
            
            // calculating difference between heights of both buildings.
            int diff = Math.max(h1, h2) - Math.min(h1, h2);
            j += diff;
            
            // calculating maximum height possible between both buildings.
            max = Math.max(max, Math.max(h1, h2) + (k - j)/2);
        }
        
        return max;
    }
}