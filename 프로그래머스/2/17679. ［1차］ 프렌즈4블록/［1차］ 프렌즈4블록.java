class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] table=  new char[m][n];
        for(int i=0;i<m;i++){
            table[i]=board[m-i-1].toCharArray();
        }
        
        while(true){
            // 제거할 블록 체크
            boolean[][] canRemove = new boolean[m][n];
            boolean hasRemoved = false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(table[i][j] == '-') continue;
                    
                    char curr = table[i][j];
                    
                    // 아래, 오른쪽, 대각선 (사각형) 체크
                    if(table[i+1][j] == curr &&
                        table[i][j+1] == curr &&
                        table[i+1][j+1] == curr){
                        canRemove[i][j] = true;
                        canRemove[i+1][j] = true;
                        canRemove[i][j+1] = true;
                        canRemove[i+1][j+1] = true;
                        
                        hasRemoved = true;
                    }
                }
            }
            
            // 탈출 : 더이상 블록 제거가 안될때
            if(!hasRemoved) break;
            
            // 블록 제거 작업 ('-'로 변경)
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(canRemove[i][j]){
                        answer++;
                        table[i][j] = '-';
                    }
                }
            }
            
            // table 갱신
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(table[i][j]=='-'){
                       for(int k=i;k<m;k++){
                           if(table[k][j]=='-'){
                               continue;
                           }
                           table[i][j]=table[k][j];
                           table[k][j]='-';
                           break;
                       }
                    }
                }
            }
        }
        
        return answer;
    }
}