use std::collections::VecDeque;

impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        let mut sum = 0i64;
        let mut ans = n + 1;
        let mut deque = VecDeque::new();
        deque.push_back((0i64, 0));

        for i in 0..n {
            sum += nums[i] as i64;
            let cur_idx = i + 1;

            // Unified Front Pruning
            while let Some(&(s, idx)) = deque.front() {
                if sum - s >= k {
                    ans = ans.min(cur_idx - idx);
                    deque.pop_front();
                } else if cur_idx - idx >= ans {
                    deque.pop_front();
                } else {
                    break;
                }
            }

            // Back Pruning (Monotonicity)
            while deque.back().map_or(false, |&(s, _)| sum <= s) {
                deque.pop_back();
            }
            deque.push_back((sum, cur_idx));
        }

        if ans > n { -1 } else { ans as i32 }
    }
}