import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 벽 3개 세우기
 *      - 빈칸들 중, 3칸을 골라 벽을 세우기
 *      - 재귀 (조합)
 * 2. 바이러스 퍼뜨리기
 *      -
 * 3. 안정영역 계산하기 (+최댓값 갱신하기)
 * 4. 최댓값 출력하기
 */
public class Main {
    private static int N;
    private static int M;
    private static int[][] board;
    private static int answer = Integer.MIN_VALUE;
    private static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로길이
        M = Integer.parseInt(st.nextToken()); // 가로길이

        // 초기화
        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//     벽 3개 세우는 경우
        dfs(0);

        System.out.println(answer);
    }


    private static void dfs(int count){
        if(count == 3){
            // 바이러스 퍼뜨리기
            int[][] virusBoard = deepCopy(board);
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(virusBoard[i][j] == 2)
                        spreadVirus(virusBoard, i, j);
                }
            }

            // 안전영역 구하기
            answer = Math.max(countSafeZone(virusBoard), answer);
            return;
        }

        // 백트래킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) { // 빈칸인 경우
                    board[i][j] = 1;
                    dfs(count + 1);
                    board[i][j] = 0; // 백트래킹
                }
            }
        }
    }


    private static void spreadVirus(int[][] board, int r, int c){
        // 바이러스 퍼뜨리기
        board[r][c] = 2;

        // 상하좌우 이동
        for(int i=0; i<4; i++){
            int nextR = r+move[i][0];
            int nextC = c+move[i][1];

            if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;

            if(board[nextR][nextC] == 0) spreadVirus(board, nextR, nextC);
        }
    }

    private static int countSafeZone(int[][] board){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0) count++;
            }
        }
        return count;
    }

    // 2차원 배열 깊은 복사
    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}


