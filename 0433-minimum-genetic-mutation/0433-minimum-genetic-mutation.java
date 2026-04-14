class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int n = 8;

        boolean exist = false;

        for(String str : bank) {
            if(end.equals(str)) exist = true;
        }

        if(!exist) return -1;

        int diff = 0;
        for(int i = 0; i < 8; i++) {
            if(start.charAt(i) != end.charAt(i)) diff++;
        }

        return diff;
    }
}