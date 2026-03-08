class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String x : tokens){

            if(isOperator(x)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operate(a,b,x));
            } else {
                stack.push(Integer.parseInt(x));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String x){
        return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
    }

    private int operate(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }
}