class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int r = 0; r<arr1.length; r++){
            for(int c=0; c<arr2[0].length; c++){
                for(int k=0; k<arr2.length; k++){
                    answer[r][c] += arr1[r][k] * arr2[k][c];
                }
            }
        }
        
        return answer;
    }
}