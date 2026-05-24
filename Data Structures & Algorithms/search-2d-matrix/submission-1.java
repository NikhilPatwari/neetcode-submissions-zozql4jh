class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = (row * col);
        int l = 0, r = n - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int i = getI(mid, col);
            int j = getJ(mid, col);
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    public int getI(int index, int c) {
        return index / c;
    }
    public int getJ(int index, int c) {
        return index % c;
    }
}
