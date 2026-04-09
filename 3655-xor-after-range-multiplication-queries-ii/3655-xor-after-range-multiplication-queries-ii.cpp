class Solution {
public:

  long long binpow(long long a, long long b, long long m) {
        long long res = 1;
        while (b > 0) {
            if (b & 1)
                res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        int b = sqrt(n) + 1;
        int mod = 1e9 + 7;

        for(auto it: queries) {
            if(it[2] > b) {
                int l = it[0];
                int r = it[1];
                int v = it[3];

                while(l <= r) {
                    nums[l] = (1LL* nums[l] * v) % mod;
                    l += it[2];
                }
            }
        }

       vector<int> inv[b + 1];
       for(int i = 0; i <= b; i ++) {
        for(int j = 0; j < n; j ++) {
            inv[i].push_back(1);
        }
       }

       for(auto it: queries) {
        if(it[2] <= b) {
            int l = it[0];
            int r = it[1];
            int v = it[3];
            int k = it[2];

           int fk = ((l - r) % k + k) % k;
           fk = fk ? fk : k;
           int actual_r = r + fk;


            inv[k][l] = (1LL * v * inv[k][l]) % mod;
            int inverted = binpow(v, mod - 2, mod);
            if(actual_r < n) {
                inv[k][actual_r] = (1LL * inv[k][actual_r] * inverted) % mod;
            }
            
        }
       }


       for(int k = 1; k <= b; k ++) {
        for(int i = 0; i < k; i ++) {
            int cur = 1;
            for(int j = i; j < n; j += k) {
                cur = (1LL * cur * inv[k][j]) % mod;
                nums[j] = (1LL*nums[j] * cur) % mod;
            }
        }
       }

       long long ans = 0;

       for(int i = 0; i < n; i ++) {
        ans ^= nums[i];
       }

        return ans;
    }
};