class Solution {
    HashSet<Integer> st;
    PriorityQueue<Integer> minh;
    int n;
    int m;
    public int[] getBiggestThree(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        minh = new PriorityQueue<>();
        st = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //finding centre of each rhombus
                rhombusWithCurrentCentre(grid,i,j);
            }
        }
        int ans[] = new int[minh.size()];
        int ind = ans.length-1;
        while(minh.size()>0)
        {
            ans[ind--] = minh.poll();
        }
        return ans;
    }
    public void rhombusWithCurrentCentre(int grid[][],int r,int c)
    {
        int sum = grid[r][c];
        if(st.contains(sum)==false)
        {
            minh.add(sum);
            if(minh.size()>3)
            {
                minh.poll();
            }
            st.add(sum);
        }
        int size = 1;
        while(true)
        {
            if(insideGrid(r+size,c)==false) break;
            if(insideGrid(r-size,c)==false) break;
            if(insideGrid(r,c+size)==false) break;
            if(insideGrid(r,c-size)==false) break;
            sum = 0;
            for(int i=0;i<=size;i++)
            {
                sum += grid[r-size+i][c+i];
                sum += grid[r-size+i][c-i];

                sum += grid[r+size-i][c+i];
                sum += grid[r+size-i][c-i];
            }
            sum -= grid[r + size][c];
            sum -= grid[r - size][c];
            sum -= grid[r][c-size];
            sum -= grid[r][c+size];

            if(st.contains(sum)==false)
            {
                minh.add(sum);
                if(minh.size()>3)
                {
                    minh.poll();
                }
                st.add(sum);
            }
            size++;
        }
    }
    public boolean insideGrid(int r,int c)
    {
        if(r<0 || r>=n || c<0 || c>=m)
        {
            return false;
        }
        return true;
    }
}