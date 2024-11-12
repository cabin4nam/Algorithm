class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        
        int size = arr.length;
        checkNums(arr, size, 0, 0);
//         while(size > 1){
//             // S 내부에 있는 수가 모두 같은 수인지 확인
            

//             // 압축
//             size /= 2;
//         }

        // 개수 세기
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] == 0) answer[0] ++;
                else if(arr[i][j] == 1) answer[1] ++;
            }
        }
        
        return answer;
    }
    
    private static void checkNums(int[][] arr, int size, int r, int c){
        if(r >= arr.length || c >= arr.length) return;
        if(size <= 1) return;
        int num = arr[r][c];
        boolean canPress = true;
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[i][j] != num){
                    canPress = false;
                    break;
                }
            }
        }
        
        // 압축
        if(canPress){
            // 하나만 남기고 다 -1로 채우기
            for(int i=r; i<r+size; i++){
                for(int j=c; j<c+size; j++){
                    arr[i][j] = -1;
                }
            }
            arr[r][c] = num; 
        }
        
        checkNums(arr, size/2, r, c);
        checkNums(arr, size/2, r+(size/2), c);
        checkNums(arr, size/2, r, c+(size/2));
        checkNums(arr, size/2, r+(size/2), c+(size/2));
    }
}