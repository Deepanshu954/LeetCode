impl Solution {
    pub fn longest_balanced(s: String) -> i32 {
        let n = s.len();
        if n == 0 {
            return 0;
        }

        // Access raw bytes. 
        // We will use unsafe get_unchecked later to avoid boundary checks.
        let s_bytes = s.as_bytes();
        
        let mut max_len = 0;

        for i in 0..n {
            // PRUNING:
            // If the remaining characters are fewer than the current best answer,
            // it is impossible to find a better solution. Stop immediately.
            if n - i <= max_len {
                break;
            }

            // Stack-allocated frequency map.
            // u16 is sufficient (max length 1000) and fits in 52 bytes (1 cache line).
            let mut cnt = [0u16; 26];
            
            let mut distinct = 0;
            let mut max_freq = 0;
            let mut num_max = 0;

            // PHASE 1: CATCH-UP
            // We know we can't beat the record until we process at least 'max_len' characters.
            // So we run a raw loop without any validity checks to "fast forward" the state.
            let limit = std::cmp::min(n, i + max_len);
            let mut j = i;

            while j < limit {
                // UNSAFE OPTIMIZATION:
                // Skip bounds checking. We know j < n.
                let idx = unsafe { *s_bytes.get_unchecked(j) } as usize - 97; // 97 is 'a'

                if cnt[idx] == 0 { distinct += 1; }
                cnt[idx] += 1;
                let f = cnt[idx];

                if f > max_freq {
                    max_freq = f;
                    num_max = 1;
                } else if f == max_freq {
                    num_max += 1;
                }
                j += 1;
            }

            // PHASE 2: CHECK FOR RECORD
            // Now we are in uncharted territory. Every step could be a new max_len.
            while j < n {
                let idx = unsafe { *s_bytes.get_unchecked(j) } as usize - 97;

                if cnt[idx] == 0 { distinct += 1; }
                cnt[idx] += 1;
                let f = cnt[idx];

                if f > max_freq {
                    max_freq = f;
                    num_max = 1;
                } else if f == max_freq {
                    num_max += 1;
                }

                // VALIDITY CHECK:
                // A substring is balanced if ALL distinct characters have the same frequency.
                // This implies: (Count of chars with max_freq) == (Total distinct chars)
                if num_max == distinct {
                    // Since we are in Phase 2, we know j - i + 1 > max_len
                    max_len = j - i + 1;
                }
                j += 1;
            }
        }

        max_len as i32
    }
}
