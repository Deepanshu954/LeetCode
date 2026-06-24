class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int rangeSize = r - l + 1;
        int matrixDimension = 2 * rangeSize;
        
        MatrixTransitionEngine engine = new MatrixTransitionEngine(matrixDimension);
        int[][] transitionMatrix = engine.buildTransitionMatrix(rangeSize);
        int[][] exponentiatedMatrix = engine.power(transitionMatrix, n - 1);
        
        return engine.calculateTotalCombinations(exponentiatedMatrix);
    }
}

class MatrixTransitionEngine {
    private int dimension;
    private int moduloBoundary = 1000000007;

    public MatrixTransitionEngine(int dimension) {
        this.dimension = dimension;
    }

    public int[][] buildTransitionMatrix(int rangeSize) {
        int[][] matrix = new int[dimension][dimension];
        for (int currentVal = 0; currentVal < rangeSize; currentVal++) {
            for (int previousVal = 0; previousVal < rangeSize; previousVal++) {
                if (previousVal < currentVal) {
                    matrix[currentVal][previousVal + rangeSize] = 1;
                }
                if (previousVal > currentVal) {
                    matrix[currentVal + rangeSize][previousVal] = 1;
                }
            }
        }
        return matrix;
    }

    public int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] resultMatrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int common = 0; common < dimension; common++) {
                if (matrixA[row][common] == 0) {
                    continue;
                }
                for (int col = 0; col < dimension; col++) {
                    long product = (1L * matrixA[row][common] * matrixB[common][col]) % moduloBoundary;
                    resultMatrix[row][col] = (int) ((resultMatrix[row][col] + product) % moduloBoundary);
                }
            }
        }
        return resultMatrix;
    }

    public int[][] power(int[][] baseMatrix, int exponent) {
        int[][] resultMatrix = new int[dimension][dimension];
        for (int index = 0; index < dimension; index++) {
            resultMatrix[index][index] = 1;
        }
        
        int[][] currentBase = baseMatrix;
        int currentExponent = exponent;
        
        while (currentExponent > 0) {
            if (currentExponent % 2 == 1) {
                resultMatrix = multiply(resultMatrix, currentBase);
            }
            currentBase = multiply(currentBase, currentBase);
            currentExponent /= 2;
        }
        return resultMatrix;
    }

    public int calculateTotalCombinations(int[][] matrix) {
        long totalCombinations = 0;
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                totalCombinations = (totalCombinations + matrix[row][col]) % moduloBoundary;
            }
        }
        return (int) totalCombinations;
    }
}