impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        let mut min_len = (n + 1) as i32;

        let mut q_vals = Vec::<i64>::with_capacity(n + 1);
        let mut q_idxs = Vec::<i32>::with_capacity(n + 1);

        unsafe {
            let q_vals_ptr = q_vals.as_mut_ptr();
            let q_idxs_ptr = q_idxs.as_mut_ptr();
            
            let mut head = 0;
            let mut tail = 0;

            *q_vals_ptr = 0;
            *q_idxs_ptr = 0; 
            tail += 1;

            let mut curr_sum: i64 = 0;

            for i in 0..n {

                curr_sum += *nums.get_unchecked(i) as i64;
                let curr_idx = (i + 1) as i32;

                while head < tail {
                    let val = *q_vals_ptr.add(head);
                    if curr_sum - val >= k {
                        let idx = *q_idxs_ptr.add(head);
                        let len = curr_idx - idx;
                        if len < min_len {
                            min_len = len;
                        }
                        head += 1;
                    } else {
                        break;
                    }
                }

                while head < tail {
                    let val = *q_vals_ptr.add(tail - 1);
                    if curr_sum <= val {
                        tail -= 1;
                    } else {
                        break;
                    }
                }

                *q_vals_ptr.add(tail) = curr_sum;
                *q_idxs_ptr.add(tail) = curr_idx;
                tail += 1;
            }
        }

        if min_len > n as i32 { -1 } else { min_len }
    }
}