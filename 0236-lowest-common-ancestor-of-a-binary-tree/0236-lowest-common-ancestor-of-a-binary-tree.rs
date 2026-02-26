use std::rc::Rc;
use std::cell::RefCell;
use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn lowest_common_ancestor(
        root: Option<Rc<RefCell<TreeNode>>>,
        p: Option<Rc<RefCell<TreeNode>>>,
        q: Option<Rc<RefCell<TreeNode>>>,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        let mut parent_map = HashMap::with_capacity(1024);
        let mut stack = Vec::with_capacity(1024);
        
        let root_ptr = root.as_ref().unwrap().as_ptr();
        let p_ptr = p.as_ref().unwrap().as_ptr();
        let q_ptr = q.as_ref().unwrap().as_ptr();

        stack.push(root.clone().unwrap());

        // Map parent pointers via memory addresses
        while !parent_map.contains_key(&p_ptr) || !parent_map.contains_key(&q_ptr) {
            if let Some(node) = stack.pop() {
                let current_ptr = node.as_ptr();
                
                if let Some(left) = &node.borrow().left {
                    parent_map.insert(left.as_ptr(), node.clone());
                    stack.push(left.clone());
                }
                if let Some(right) = &node.borrow().right {
                    parent_map.insert(right.as_ptr(), node.clone());
                    stack.push(right.clone());
                }
            } else {
                break;
            }
        }

        let mut ancestors = HashSet::with_capacity(512);
        let mut curr_p = Some(p.unwrap());

        // Trace p's lineage
        while let Some(node) = curr_p {
            let ptr = node.as_ptr();
            ancestors.insert(ptr);
            curr_p = parent_map.get(&ptr).cloned();
        }

        let mut curr_q = Some(q.unwrap());

        // Find intersection
        while let Some(node) = curr_q {
            let ptr = node.as_ptr();
            if ancestors.contains(&ptr) {
                return Some(node);
            }
            curr_q = parent_map.get(&ptr).cloned();
        }

        None
    }
}