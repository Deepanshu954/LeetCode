use std::cmp;

impl Solution {
    pub fn longest_balanced(s: String) -> i32 {
        let n = s.len();
        if n == 0 { return 0; }
        
        // Convert to bytes for O(1) access
        let bytes = s.as_bytes();
        // Map to 0-25 usize for array indexing
        let nums: Vec<usize> = bytes.iter().map(|&b| (b - b'a') as usize).collect();
        
        let mut max_len = 0;

        for i in 0..n {
            // Pruning
            if n - i <= max_len {
                break;
            }

            // Stack allocated array [u16; 26]
            let mut cnt = [0u16; 26];
            let mut distinct = 0;
            let mut max_freq = 0;
            let mut num_max = 0;

            // Split loop strategy
            let limit = cmp::min(n, i + max_len);
            
            // Phase 1: Catch up
            for j in i..limit {
                let idx = unsafe { *nums.get_unchecked(j) };
                
                if cnt[idx] == 0 { distinct += 1; }
                cnt[idx] += 1;
                let c = cnt[idx];
                
                if c > max_freq {
                    max_freq = c;
                    num_max = 1;
                } else if c == max_freq {
                    num_max += 1;
                }
            }
            
            // Phase 2: Check
            for j in limit..n {
                let idx = unsafe { *nums.get_unchecked(j) };
                
                if cnt[idx] == 0 { distinct += 1; }
                cnt[idx] += 1;
                let c = cnt[idx];
                
                if c > max_freq {
                    max_freq = c;
                    num_max = 1;
                } else if c == max_freq {
                    num_max += 1;
                }

                // If number of items with max frequency equals total distinct items
                if num_max == distinct {
                    max_len = j - i + 1;
                }
            }
        }
        max_len as i32
    }
}