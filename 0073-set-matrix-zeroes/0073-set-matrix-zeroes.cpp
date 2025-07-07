class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) 
    {
        int row = matrix.size();
        int col = matrix[0].size();

        vector<int> arr1;
        vector<int> arr2;

        // ✅ Proper 2D traversal
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == 0)
                {
                    arr1.push_back(i);
                    arr2.push_back(j);
                }
            }
        }

        int size = arr1.size();

        // ✅ Zero out rows
        for(int i = 0; i < size; i++)
        {
            int rowIdx = arr1[i];
            for(int j = 0; j < col; j++)
            {
                matrix[rowIdx][j] = 0;
            }
        }

        // ✅ Zero out columns
        for(int i = 0; i < size; i++)
        {
            int colIdx = arr2[i];
            for(int j = 0; j < row; j++)
            {
                matrix[j][colIdx] = 0;
            }
        }
    }
};