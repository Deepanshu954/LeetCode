impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        
        // We track the minimum length found. 
        // Initializing to n + 1 (impossible value).
        let mut min_len = (n + 1) as i32;

        // OPTIMIZATION 1: Uninitialized Memory + Structure of Arrays (SoA)
        // Standard Vec![] zeros out memory (slow). 
        // Vec::with_capacity allocates but doesn't write (instant).
        // We split the Deque into two arrays (Sums and Indices) to improve CPU Cache alignment.
        let mut q_sum = Vec::<i64>::with_capacity(n + 1);
        let mut q_idx = Vec::<i32>::with_capacity(n + 1);

        unsafe {
            // OPTIMIZATION 2: Raw Pointers
            // Accessing memory via pointers avoids bounds checking panic logic entirely.
            let sum_ptr = q_sum.as_mut_ptr();
            let idx_ptr = q_idx.as_mut_ptr();

            // Manual Deque Pointers
            let mut head = 0;
            let mut tail = 0;

            // Initialize Deque with state (sum=0, index=-1)
            // This represents the prefix sum before the array starts.
            *sum_ptr = 0;
            *idx_ptr = -1;
            tail += 1;

            let mut curr_sum: i64 = 0;

            // OPTIMIZATION 3: Raw Loop
            for i in 0..n {
                // Read input without bounds check
                curr_sum += *nums.get_unchecked(i) as i64;

                // PHASE 1: CHECK VALIDITY (Shrink from Head)
                // We access the raw pointer directly. 
                // Since 'head' increments sequentially, this is very cache-friendly.
                while head < tail {
                    let prefix_sum = *sum_ptr.add(head);
                    
                    // The core logic: P[y] - P[x] >= k
                    if curr_sum - prefix_sum >= k {
                        let start_idx = *idx_ptr.add(head);
                        let len = (i as i32) - start_idx;
                        
                        // Update result if smaller
                        if len < min_len {
                            min_len = len;
                        }
                        head += 1; // Pop front
                    } else {
                        break;
                    }
                }

                // PHASE 2: MAINTAIN MONOTONICITY (Shrink from Tail)
                // Keep the queue increasing. If curr_sum is smaller than the back,
                // the back is useless (suboptimal).
                while head < tail {
                    let last_sum = *sum_ptr.add(tail - 1);
                    if curr_sum <= last_sum {
                        tail -= 1; // Pop back
                    } else {
                        break;
                    }
                }

                // PHASE 3: PUSH BACK
                // Write directly to uninitialized memory at 'tail'
                *sum_ptr.add(tail) = curr_sum;
                *idx_ptr.add(tail) = i as i32;
                tail += 1;
            }
        }

        if min_len > n as i32 { -1 } else { min_len }
    }
}