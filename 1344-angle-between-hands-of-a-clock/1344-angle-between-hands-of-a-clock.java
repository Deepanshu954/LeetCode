
class Solution {
    public double angleClock(int hour, int min) {
        double m = min * 6;
        double h = ((hour * 30) + min * 0.5) % 360;

        double res = Math.abs(m - h);
        res = Math.min(res, 360 - res);
        
        return res;
    }
}