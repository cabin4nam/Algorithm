import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private static int answer = Integer.MIN_VALUE;
    private static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 음식물 개수

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;

            points.add(new Point(r,c));
        }

        for(Point p : points){
            count = 0;
            dfs(p.r, p.c);

            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c){
        visited[r][c] = true;
        count ++;

        for(int i=0; i<4; i++){
            int nextR = r+move[i][0];
            int nextC = c+move[i][1];

            if(nextR < 1 || nextC < 1 || nextR > N || nextC > M) continue;
            if(visited[nextR][nextC]) continue;
            if(map[nextR][nextC] != 1) continue;

            dfs(nextR, nextC);
        }
    }
}