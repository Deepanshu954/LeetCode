class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // 1: Land ride first, then Water ride
                int landFinish = landStartTime[i] + landDuration[i];
                int totalFinish1 = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];
                
                // 2: Water ride first, then Land ride
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int totalFinish2 = Math.max(waterFinish, landStartTime[i]) + landDuration[i];
                
                // Update 
                minFinishTime = Math.min(minFinishTime, Math.min(totalFinish1, totalFinish2));
            }
        }
        
        return minFinishTime;
    }
}
