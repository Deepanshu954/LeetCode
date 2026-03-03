class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        int len = (int)(Math.pow(2,n)-1);
        int mid = (len/2)+1;

        if(mid==k)return '1';
        if(k<mid) return findKthBit(n-1,k);
        else {
            char ch = findKthBit(n - 1, len - k + 1);
            if(ch == '0') return '1';
            else return '0';
        }
    }
}