class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if(rows == 1 && columns == 1) {
            if (matrix[0][0] == target) {
                return true;
            } else {

                return false;
            } 

        }

        if(rows == 1) {
            if (matrix[0][0] == target || matrix[0][columns-1] == target) {
                return true;
            }
        }

        if (columns == 1) {

            

        int l = 0;
        int r = rows * columns - 1 ;

        if (matrix[0][0] == target || matrix[r][0] == target) {
                return true;
            }
        
        while(l < r) {
            int mid = (l + r)/2;

            if(matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return false;

        }

        int l = 0;
        int r = rows * columns - 1 ;

        if (matrix[0][0] == target || matrix[rows-1][columns-1] == target) {
                return true;
            }
        
        while(l < r) {
            int mid = (l + r)/2;
            int tr = mid/columns;
            int tc = mid%columns;

            if(matrix[tr][tc] == target) {
                return true;
            } else if (matrix[tr][tc] > target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return false;
    }
}
