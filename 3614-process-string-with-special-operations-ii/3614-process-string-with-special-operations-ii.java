class Solution {
    public char processStr(String s, long k) {
        long size = 0;

        // Step 1: compute final size
        for(char ch : s.toCharArray()) {
            if(ch == '*') {
                if(size > 0) size--;
            } else if(ch == '#') {
                size *= 2;
            } else if(ch == '%') {
                // reverse → size same
            } else {
                size++;
            }
        }

        if(k >= size) return '.';

        // Step 2: reverse simulate
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == '*') {
                size++;
            } 
            else if(ch == '#') {
                size /= 2;
                if(k >= size) k -= size;
            } 
            else if(ch == '%') {
                k = size - k - 1;
            } 
            else {
                size--;
                if(k == size) return ch;
            }
        }

        return '.';
    }
}

// class Solution {
//     public char processStr(String s, long k) {
//         String str = process(s);

//         long size = str.length();
//         if(k >= size) return '.';

//         return str.charAt((int) k);
        
//     }

//     private String process(String s) {
//          StringBuilder sb = new StringBuilder();

//         for(char ch : s.toCharArray()) {
//             if(ch == '*') {
//                 if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
//             }
//             else if(ch == '#') sb.append(sb.toString());
//             else if(ch == '%') sb.reverse();
//             else sb.append(ch);
//         }

//         return sb.toString();
//     }
// }