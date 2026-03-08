class MinStack {
	        private Deque<Integer> stack = new ArrayDeque<>();
	        private Deque<Integer> minStack = new ArrayDeque<>();
	        
	        public MinStack() {
            }
            
            public void push(int val) {
                if (minStack.isEmpty() || val <= minStack.peek()) 
                    minStack.push(val);
                stack.push(val);
            }
            
            public void pop() {
                int v = stack.pop();
                if (minStack.peek() == v) minStack.pop();
            }
            
            public int top() {
                return stack.peek();
            }
            
            public int getMin() {
                return minStack.peek();
            }
}
