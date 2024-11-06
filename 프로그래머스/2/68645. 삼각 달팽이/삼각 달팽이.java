import java.util.*;
class Solution {
    
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[][] arr = new int[n+1][n+1];
        int[] dr = {1, 0, -1}; // 아래, 오른쪽, 위쪽 방향
        int[] dc = {0, 1, -1};
        
        int sum = n*(n+1)/2;
        int r = 1;
        int c = 1;
        int count = 1;
        int direction = 0;
        
        // 삼각형의 모든 사각형을 채울 때 까지
        while(count <= sum){
            arr[r][c] = count++;
            int nr = r + dr[direction];
            int nc = c + dc[direction];
            
            // 빙향 전환
            if(nr > n || nc > nr || nr < 1 || nc < 1 || arr[nr][nc] != 0){
                direction = (direction + 1) % 3;
                nr = r + dr[direction];
                nc = c + dc[direction];
            }
            
            r = nr;
            c = nc;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] != 0) answer.add(arr[i][j]);
            }
        }
        
        return answer;
    }
}