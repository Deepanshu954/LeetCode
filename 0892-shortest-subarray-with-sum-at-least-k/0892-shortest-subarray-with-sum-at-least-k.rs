impl Solution {
    pub fn shortest_subarray(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let k = k as i64;
        let mut min_len = (n + 1) as i32;

        unsafe {
            // Preallocate prefix + deque in one go
            let mut prefix = Vec::<i64>::with_capacity(n + 1);
            prefix.set_len(n + 1);

            *prefix.get_unchecked_mut(0) = 0;

            for i in 0..n {
                let prev = *prefix.get_unchecked(i);
                *prefix.get_unchecked_mut(i + 1) =
                    prev + *nums.get_unchecked(i) as i64;
            }

            // Deque as raw index buffer
            let mut dq = Vec::<usize>::with_capacity(n + 1);
            dq.set_len(n + 1);

            let dq_ptr = dq.as_mut_ptr();
            let pref_ptr = prefix.as_ptr();

            let mut head = 0usize;
            let mut tail = 0usize;

            for i in 0..=n {
                let curr = *pref_ptr.add(i);

                // Pop from front if valid
                while head < tail {
                    let idx = *dq_ptr.add(head);
                    if curr - *pref_ptr.add(idx) >= k {
                        let len = (i - idx) as i32;
                        if len < min_len {
                            min_len = len;
                        }
                        head += 1;
                    } else {
                        break;
                    }
                }

                // Maintain monotonic increasing prefix
                while head < tail {
                    let last = *dq_ptr.add(tail - 1);
                    if curr <= *pref_ptr.add(last) {
                        tail -= 1;
                    } else {
                        break;
                    }
                }

                *dq_ptr.add(tail) = i;
                tail += 1;
            }
        }

        if min_len > n as i32 { -1 } else { min_len }
    }
}