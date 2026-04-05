class NumMatrix {
    private final int [][] matrix;

    public NumMatrix(int[][] m) {
        int rows = m.length + 1;
        int cols = m[0].length + 1;
        this.matrix = new int[rows][cols];
        for(int r = 0; r < rows -1; r++) {
            int rowPrefix = 0;
           for(int c = 0; c < cols -1; c++){
                rowPrefix += m[r][c];
                int above = matrix[r][c+1];
                matrix[r+1][c+1] = rowPrefix + above;  
           }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = matrix[row2][col2];
        int above = matrix[row1 - 1][col2];
        int left = matrix[row2][col1 - 1];
        int topLeft = matrix[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */