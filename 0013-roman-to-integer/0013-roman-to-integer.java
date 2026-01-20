class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            int val = value(s.charAt(i));

            if(i + 1 < s.length() && val < value(s.charAt(i+1))) total -= val;
            else total += val;
        }

        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}

/*

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for(int i = 0; i < s.length(); i++){
            int val = map.get(s.charAt(i));

            if(i + 1 < s.length() && val < map.get(s.charAt(i+1))) total -= val;
            else total += val;
        }
        return total;
    }
}

*/