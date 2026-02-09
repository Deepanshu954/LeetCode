class Solution {
    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) return false;

        // manual stack
        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            }
            // closing brackets
            else {
                if (top == -1) return false; // underflow

                char open = stack[top--]; // pop

                if ((ch == ')' && open != '(') ||
                    (ch == '}' && open != '{') ||
                    (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }

        // stack must be empty
        return top == -1;
    }
}