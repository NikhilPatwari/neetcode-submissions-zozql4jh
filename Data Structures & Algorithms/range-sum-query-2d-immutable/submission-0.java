class NumMatrix {
    private final int [][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int r = row1;
        while (r<=row2){
            int c = col1;
            while(c <= col2){
                sum += this.matrix[r][c];
                c++;
            }
            r++;
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */