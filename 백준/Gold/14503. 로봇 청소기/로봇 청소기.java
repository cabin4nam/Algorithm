import java.util.*;
import java.io.*;

public class Main {
    static class Robot{
        int r;
        int c;
        int d; // 0 : 상, 1: 우, 2 : 하 , 3 : 좌 (반시계 방향 : -1)

        public Robot(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    // 상, 우, 하, 좌 순서대로 움직일 수 있도록
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};

    // direction에 따라 후진 -> 하, 좌, 상, 우
    static int[] moveRowBack = {1, 0, -1, 0};
    static int[] moveColBack = {0, -1, 0, 1};

    static int N;
    static int M;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Robot robot = new Robot(row, col, dir);
        moveRobot(robot);

        System.out.println(answer);
    }

    private static void moveRobot(Robot robot){

        if(map[robot.r][robot.c] == 0){
            map[robot.r][robot.c] = -1;
            answer++;
        }

        boolean canGo = false;
        for (int idx = 0; idx < 4; idx++) {
            // 반시계 방향
            int nextDir = (robot.d + 3) % 4;
            int nextRow = robot.r + moveRow[nextDir];
            int nextCol = robot.c + moveCol[nextDir];

            if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;


            // 청소하기위해 이동 가능
            if(map[nextRow][nextCol] == 0){
                canGo = true;
                moveRobot(new Robot(nextRow, nextCol, nextDir));
                return;
            }

            robot.d = nextDir;
        }

        // 후진 시도
        int backRow = robot.r + moveRowBack[robot.d];
        int backCol = robot.c + moveColBack[robot.d];

        if(backRow < 0 || backCol < 0 || backRow >= N || backCol >= M) return;
        if(map[backRow][backCol] == 1) return;

        moveRobot(new Robot(backRow, backCol, robot.d));
    }

}