import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bingoCount = 0; // 전체 빙고 수 - 3개가 되면 win
        int[] rowMatchCount = {0, 0, 0, 0, 0};
        int[] colMatchCount = {0, 0, 0, 0, 0};
        int[] crossMatchCount = {0, 0}; // 오른쪽 대각선, 왼쪽 대각선

        int[][] bingo = new int[5][5];
        // bingo 입력받기
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자 명령 입력받아서, 반복 -> 25개의 명령
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                
                // 빙고에서 num 찾기
                int bingoRow = -1;
                int bingoCol = -1;
                for(int r=0; r<5; r++){
                    for(int c=0; c<5; c++){
                        if(bingo[r][c] == num){
                            bingoRow = r;
                            bingoCol = c;
                        }
                    }
                }

                if(bingoRow == -1 || bingoCol == -1) continue;

                // 가로줄 빙고 검사
                rowMatchCount[bingoRow] ++;
                if(rowMatchCount[bingoRow] == 5){
                    bingoCount++;
                    rowMatchCount[bingoRow] = -1;
                }
                
                // 세로줄 빙고 검사
                colMatchCount[bingoCol] ++;
                if(colMatchCount[bingoCol] == 5){
                    bingoCount++;
                    rowMatchCount[bingoCol] = -1;
                }
                
                // 대각선 빙고 검사
                if(bingoRow == bingoCol) crossMatchCount[0]++;
                if(crossMatchCount[0] == 5) {
                    bingoCount ++;
                    crossMatchCount[0] = -1;
                }
                if(bingoRow + bingoCol == 4) crossMatchCount[1]++;
                if(crossMatchCount[1] == 5){
                    bingoCount ++;
                    crossMatchCount[1] = -1;
                }

                // 빙고가 3개면 win
                if(bingoCount >= 3) {
                    System.out.println((i*5)+j+1);
                    return;
                }

            }
        }

    }


}