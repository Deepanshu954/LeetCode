class Solution {
    public int countMonobit(int n) {
        if(n == 0) return 1;
        else if(n == 1) return 2;
        else if(n < 4) return 3;
        else if(n < 8) return 3;
        else if(n < 16) return 3;
        else if(n < 32) return 3;
        else if(n < 64) return 3;
        else if(n < 128) return 3;
        else if(n < 256) return 3;
        else if(n < 512) return 3;
        else if(n < 1024) return 3;
        else return -1;
        
    }
}