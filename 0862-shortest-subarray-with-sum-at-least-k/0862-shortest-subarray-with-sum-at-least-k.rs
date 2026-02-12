use std::collections::VecDeque;

impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;

        let (_, _, min_len) = nums.iter().enumerate().fold(
            (0i64, VecDeque::from([(0i64, 0)]), n + 1),
            |(mut sum, mut deque, mut ans), (i, &num)| {
                sum += num as i64;
                let idx = i + 1;

                while let Some(&(_, start_idx)) = deque.front()
                    && idx - start_idx >= ans
                {
                    deque.pop_front();
                }

                while let Some(&(s, start_idx)) = deque.front()
                    && sum - s >= k
                {
                    ans = idx - start_idx;
                    deque.pop_front();
                }

                while let Some(&(s, _)) = deque.back()
                    && sum <= s
                {
                    deque.pop_back();
                }

                deque.push_back((sum, idx));
                (sum, deque, ans)
            },
        );

        if min_len > n { -1 } else { min_len as i32 }
    }
}