class MinStack {

    private int[] stack = new int[30000];
    private int[] minStack = new int[30000];
    private int index = -1;

    public MinStack() {}

    public void push(int val) {
        index++;
        stack[index] = val;

        if (index == 0) {
            minStack[index] = val;
        } else {
            minStack[index] = Math.min(val, minStack[index - 1]);
        }
    }

    public void pop() {
        if (index == -1) return;
        index--;
    }

    public int top() {
        return stack[index];
    }

    public int getMin() {
        return minStack[index];
    }
}