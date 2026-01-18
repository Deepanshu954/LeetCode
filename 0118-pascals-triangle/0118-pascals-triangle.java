class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> tri = new ArrayList<>();

        for(int i = 0; i < n; i++){

            List<Integer> row = new ArrayList();
            row.add(1);

            for(int j = 1; j < i; j++){
                int val = tri.get(i - 1).get(j - 1) + tri.get(i-1).get(j);
                row.add(val);
            }
            
            if(i > 0) row.add(1);
            tri.add(row);
        }
        return tri;
    }
}