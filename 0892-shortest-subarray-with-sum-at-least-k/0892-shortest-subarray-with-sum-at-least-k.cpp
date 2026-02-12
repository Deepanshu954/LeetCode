impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        
        // OPTIMIZATION 1: Flat Array Allocation
        // Allocate space for Prefix Sums (P) and Deque (Q) immediately.
        // We use Vec but treat it as a raw buffer.
        // P[i] stores sum of nums[0..i-1]
        let mut p = vec![0i64; n + 1];
        
        // Manual Prefix Sum Calculation
        // Using iterators can be slightly slower due to abstraction, 
        // raw indexing allows loop unrolling by the compiler.
        for i in 0..n {
            unsafe {
                *p.get_unchecked_mut(i + 1) = *p.get_unchecked(i) + *nums.get_unchecked(i) as i64;
            }
        }

        // OPTIMIZATION 2: Manual Deque
        // Instead of std::collections::VecDeque, we use a fixed-size vector
        // and two integer indices (head, tail). This removes all overhead.
        let mut q = vec![0usize; n + 1]; 
        let mut head = 0;
        let mut tail = 0;

        let mut min_len = n + 1;

        // Iterate through every possible end position 'y'
        for y in 0..=n {
            let py = unsafe { *p.get_unchecked(y) };

            // 1. CHECK VALID SUBARRAYS (Shrink from front)
            // While we have a valid start point in the deque...
            while head < tail {
                unsafe {
                    let best_start_idx = *q.get_unchecked(head);
                    let px = *p.get_unchecked(best_start_idx);
                    
                    if py - px >= k {
                        // Found a valid subarray [best_start_idx ... y-1]
                        let len = y - best_start_idx;
                        if len < min_len {
                            min_len = len;
                        }
                        // Pop front: This start index is useless now because
                        // any future 'y' will produce a longer length.
                        head += 1;
                    } else {
                        // Optimization: Since P is not monotonic, we can't assume much,
                        // but the condition (py - px >= k) failed for the smallest px,
                        // so it will fail for others too if we assume local monotonicity 
                        // in the queue logic.
                        break;
                    }
                }
            }

            // 2. MAINTAIN MONOTONICITY (Shrink from back)
            // We want the deque to store indices 'x' with INCREASING P[x].
            // If py <= P[back], then 'back' is a worse candidate than 'y'
            // (since 'y' gives a smaller subtraction value and is closer to future indices).
            while head < tail {
                unsafe {
                    let last_idx = *q.get_unchecked(tail - 1);
                    let p_last = *p.get_unchecked(last_idx);
                    
                    if py <= p_last {
                        tail -= 1;
                    } else {
                        break;
                    }
                }
            }

            // 3. Push current index to back
            unsafe {
                *q.get_unchecked_mut(tail) = y;
            }
            tail += 1;
        }

        if min_len <= n {
            min_len as i32
        } else {
            -1
        }
    }
}