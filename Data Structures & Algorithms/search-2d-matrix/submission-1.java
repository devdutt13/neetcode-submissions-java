class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length-1;
        int COL = matrix[0].length-1;
        int top = 0;
        int bottom = ROW;
        while(top<=bottom){
            int mid = top +(bottom-top)/2;
            if(target > matrix[mid][COL]){
                top = mid+1;
            }else if(target < matrix[mid][0]){
                bottom = mid-1;
            }else{
                int left = 0;
                int right = COL;
                while(left<=right){
                    int middle = left +(right-left)/2;
                    if(matrix[mid][middle] > target){
                        right = middle-1;
                    }else if(matrix[mid][middle] < target){
                         left = middle+1;
                    }else{
                        return true;
                    }
                }
                return false;
            }
           
        }
        return false;
        
    }
}