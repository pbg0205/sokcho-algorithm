class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while ((row <= matrix.length - 1) && (col >= 0)) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                col -= 1;
                continue;
            }

            if (matrix[row][col] < target) {
                row += 1;
            }
        }
        return false;
    }
}
