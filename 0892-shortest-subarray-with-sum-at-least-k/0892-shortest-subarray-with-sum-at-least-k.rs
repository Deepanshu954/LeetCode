// FORCE COMPILER OPTIMIZATIONS
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

#include <vector>

using namespace std;

// GLOBAL STATIC BUFFERS (Instant Access, No Allocation Overhead)
// Size 100,005 covers the N=10^5 constraint safely.
// We reuse these for all test cases.
static long long q_val[100005];
static int q_idx[100005];

// IO SPEED HACK (Disables C++ stream syncing)
static const auto _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        // 1. Localize variables for Register caching
        int n = nums.size();
        
        // 2. Direct Pointer Access (Bypasses Vector Operator[] overhead)
        const int* raw_nums = nums.data();

        int min_len = n + 1;
        long long current_sum = 0;

        // 3. Manual Deque via Pointers/Indices
        // head: front of deque, tail: end of deque
        int head = 0;
        int tail = 0;

        // Initialize Deque with (sum=0, index=-1)
        // This handles subarrays starting from index 0.
        q_val[0] = 0;
        q_idx[0] = -1;
        tail = 1;

        // 4. Main Loop
        for (int i = 0; i < n; ++i) {
            // Update prefix sum
            current_sum += raw_nums[i];

            // OPTIMIZATION: Calculate target once per iteration
            // We are looking for: current_sum - old_sum >= k
            // Which means: old_sum <= current_sum - k
            long long target = current_sum - k;

            // PHASE 1: CHECK VALIDITY (Shrink from Head)
            // Condition: q_val[head] <= target
            // Using a pre-calculated 'target' saves 1 subtraction per loop
            while (head < tail && q_val[head] <= target) {
                int len = i - q_idx[head];
                if (len < min_len) min_len = len;
                head++;
            }

            // PHASE 2: MAINTAIN MONOTONICITY (Shrink from Tail)
            // We want q_val to be increasing.
            // If current_sum <= q_val[tail-1], the old value is useless.
            while (head < tail && current_sum <= q_val[tail - 1]) {
                tail--;
            }

            // PHASE 3: PUSH BACK
            q_val[tail] = current_sum;
            q_idx[tail] = i;
            tail++;
        }

        return min_len <= n ? min_len : -1;
    }
};