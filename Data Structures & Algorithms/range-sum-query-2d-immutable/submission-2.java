class NumMatrix {
    int[][] sumMatrix;
    int r = 0;
    int c = 0;
    public NumMatrix(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        sumMatrix = new int[r][c];
        int prevSum = 0;

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                sumMatrix[i][j] = matrix[i][j] + prevSum;
                prevSum += matrix[i][j];
            }
            prevSum = 0;
        }

        for (int j = 0; j < c; j++) {
            for (int i = r - 1; i >= 0; i--) {
                sumMatrix[i][j] += prevSum;
                prevSum = sumMatrix[i][j];
            }
            prevSum = 0;
        }

        // for(int[] a : sumMatrix){
        //     for(int b : a){
        //         System.out.print(b + ", ");
        //     }
        //     System.out.println("");
        // }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2 == r - 1 && col2 == c - 1) {
            return sumMatrix[row1][col1];
        } else if (row2 == r - 1) {
            return sumMatrix[row1][col1] - sumMatrix[row1][col2 + 1];
        } else if (col2 == c - 1) {
            return sumMatrix[row1][col1] - sumMatrix[row2 + 1][col1];
        } else {
            return sumMatrix[row1][col1] 
            - sumMatrix[row2 + 1][col1] 
            - sumMatrix[row1][col2 + 1]
            + sumMatrix[row2 + 1][col2 + 1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */