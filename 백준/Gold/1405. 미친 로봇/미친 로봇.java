import java.io.*;
import java.util.*;

public class Main{
    private static boolean[][] visited;
    private static int N;
    private static int[] movePer; // 동, 서, 남, 북
    private static int[][] move = {{0, -1}, {0, 1}, {1, 0}, {-1,0}};
    private static int SIZE = 30;
    private static double answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        movePer = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        visited = new boolean[SIZE][SIZE];
        move(0, 1, SIZE/2, SIZE/2);

        System.out.println(answer);

    }
    private static void move(int depth, double percent, int r, int c){
        visited[r][c] = true;
        if(depth == N){
            answer += percent;
            return;
        }

        for(int i=0; i<4; i++){
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];

            if(nextR < 0 || nextC < 0 || nextR > SIZE || nextC > SIZE) continue;

            if(!visited[nextR][nextC]){
                visited[nextR][nextC] = true;
                move(depth+1, percent*(movePer[i]*0.01), nextR, nextC);
                visited[nextR][nextC] = false;
            }
        }
        visited[r][c] = false;
    }
}