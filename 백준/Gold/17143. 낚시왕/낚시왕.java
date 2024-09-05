import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;
    private static int M;
    private static Shark[][] board;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 상 하 우 좌

    private static class Shark {
        public Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir - 1;
            this.size = size;
        }

        int r; // 위치 (행)
        int c; // 위치 (열)
        int speed; // 속도
        int dir; // 방향
        int size; // 크기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 격자판의 크기 (행)
        C = Integer.parseInt(st.nextToken()); // 격자판의 크기 (열)
        M = Integer.parseInt(st.nextToken()); // 상어의 수

        board = new Shark[R + 1][C + 1]; // 격자판 - 비어있으면 null, 상어가 있으면 Shark 객체 저장

        // 상어 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, z);
            board[r][c] = shark;
        }

        int manLine = 0;
        int answer = 0;

        for (int c = 1; c <= C; c++) {
            // 낚시왕 오른쪽 한 칸 이동
            manLine++;

            // 낚시왕이 있는 열에서 상어 잡기
            for (int i = 1; i <= R; i++) {
                if (board[i][manLine] != null) {
                    answer += board[i][manLine].size; // 상어 크기 더하기
                    board[i][manLine] = null; // 상어 제거
                    break; // 상어 잡았으면 더 이상 탐색하지 않음
                }
            }

            // 모든 상어 이동 처리
            moveAllSharks(); // 상어 이동 후 보드에 업데이트
        }

        System.out.println(answer);
    }

    private static void moveAllSharks() {
        Shark[][] tempBoard = new Shark[R + 1][C + 1]; // 일시적인 보드

        // 상어 이동
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (board[i][j] != null) {
                    Shark shark = board[i][j];
                    board[i][j] = null; // 현재 위치를 비우고 상어를 이동시킴
                    moveShark(shark);

                    // 이동한 위치에 이미 상어가 있으면 크기 비교 후 큰 상어만 남김
                    if (tempBoard[shark.r][shark.c] == null || tempBoard[shark.r][shark.c].size < shark.size) {
                        tempBoard[shark.r][shark.c] = shark;
                    }
                }
            }
        }

        // 이동 후 임시 보드를 기존 보드에 복사
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                board[i][j] = tempBoard[i][j]; // 이동된 상어의 위치를 반영
            }
        }
    }

    private static void moveShark(Shark shark) {
        int limit = (shark.dir < 2) ? (R - 1) * 2 : (C - 1) * 2; // 상하 방향과 좌우 방향에서 반복되는 구간 길이
        int speed = shark.speed % limit; // 속도를 보드 내 이동으로 최적화

        for (int i = 0; i < speed; i++) {
            int nextR = shark.r + move[shark.dir][0];
            int nextC = shark.c + move[shark.dir][1];

            // 벽에 부딪히면 방향 전환
            if (nextR <= 0 || nextR > R || nextC <= 0 || nextC > C) {
                if (shark.dir == 0) shark.dir = 1;
                else if (shark.dir == 1) shark.dir = 0;
                else if (shark.dir == 2) shark.dir = 3;
                else if (shark.dir == 3) shark.dir = 2;

                nextR = shark.r + move[shark.dir][0];
                nextC = shark.c + move[shark.dir][1];
            }

            shark.r = nextR;
            shark.c = nextC;
        }
    }
}
