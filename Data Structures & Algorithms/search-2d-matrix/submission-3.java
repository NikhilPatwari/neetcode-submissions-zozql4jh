class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length, left = 0, right = (r * c) -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid /c;
            int j = mid % c;
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
