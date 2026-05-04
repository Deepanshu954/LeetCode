class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int i=0;
        int j=0;
        int temp =0;
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =  temp;
            }
        }
        int low =0;
        int high = n-1;
        i=0;
        for(i=0;i<n;i++)
        {
            low = 0;
            high = n-1;
            while(low<=high)
            {
                temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}