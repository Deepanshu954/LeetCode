class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        s = s + s;

        return s.contains(goal);
    }
}

/*

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        int n = s.length();
        int m = goal.length();

        goal = goal + goal;

        for(int i = 0; i < goal.length(); i++) {
            if(goal.startsWith(s, i)) return true;
        }

        return false;
    }
}

*/