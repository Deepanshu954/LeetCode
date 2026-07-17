class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty) {
            if(tx > ty) tx %= ty;
            else ty %= tx;
        }

        if(sx == tx) return (ty >= sy) && (ty - sy) % sx == 0;
        if(sy == ty) return (tx >= sx) && (tx - sx) % sy == 0;

        return tx == sx && ty == sy;
    }
}