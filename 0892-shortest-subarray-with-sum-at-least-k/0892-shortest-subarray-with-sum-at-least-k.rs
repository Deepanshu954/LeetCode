impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        let mut min_len = (n + 1) as i32;

        // Allocate memory without initialization (Fastest possible allocation)
        // We need:
        // P: Prefix sums (i64)
        // Q: Deque indices (i32) - sufficient since N <= 10^5
        let mut p = Vec::<i64>::with_capacity(n + 1);
        let mut q = Vec::<i32>::with_capacity(n + 1);

        unsafe {
            // Get raw pointers to the allocated memory buffers
            let p_ptr = p.as_mut_ptr();
            let q_ptr = q.as_mut_ptr();

            // Initialize the first element: P[0] = 0
            *p_ptr = 0;

            // Initialize Deque with index 0
            let mut head = 0;
            let mut tail = 0;
            *q_ptr.add(tail) = 0;
            tail += 1;

            let mut curr_sum: i64 = 0;

            // Raw loop over the input array
            for i in 0..n {
                // Read nums[i] without bounds check
                // 'i' here represents the array index
                // Corresponding prefix sum index will be 'i + 1'
                curr_sum += *nums.get_unchecked(i) as i64;
                
                // Write P[i+1]
                *p_ptr.add(i + 1) = curr_sum;

                // 1. SHRINK FROM HEAD (Find valid shortest)
                // While (Current Sum - Oldest Sum >= K)
                while head < tail {
                    let front_idx = *q_ptr.add(head) as usize;
                    let prefix_front = *p_ptr.add(front_idx);
                    
                    if curr_sum - prefix_front >= k {
                        let len = (i + 1) as i32 - front_idx as i32;
                        // Branchless min update is sometimes slower, sticking to if
                        if len < min_len { 
                            min_len = len; 
                        }
                        head += 1; // Pop front
                    } else {
                        break;
                    }
                }

                // 2. MAINTAIN MONOTONICITY (Shrink from Tail)
                // Keep P[indices] increasing in the deque.
                // If Current Sum <= P[Newest Index], the newest index is useless.
                while head < tail {
                    // Peek back
                    let back_idx = *q_ptr.add(tail - 1) as usize;
                    let prefix_back = *p_ptr.add(back_idx);
                    
                    if curr_sum <= prefix_back {
                        tail -= 1; // Pop back
                    } else {
                        break;
                    }
                }

                // 3. PUSH BACK
                *q_ptr.add(tail) = (i + 1) as i32;
                tail += 1;
            }
        }

        if min_len > n as i32 { -1 } else { min_len }
    }
}