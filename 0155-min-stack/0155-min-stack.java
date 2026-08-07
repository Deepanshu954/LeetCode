class MinStack {
    int[] stack = new int[30009];
    int[] minStack = new int[30009];

    int idx = -1;

    public MinStack() {
        
    }
    
    public void push(int value) {
        idx++;
        stack[idx] = value;
        if(idx == 0) minStack[0] = value;
        else minStack[idx] = Math.min(value, minStack[idx - 1]);
    }
    
    public void pop() {
        idx--;
    }
    
    public int top() {
        return stack[idx];
    }
    
    public int getMin() {
        return minStack[idx];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */