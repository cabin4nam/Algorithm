import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static boolean[][] map;
    static boolean[][] visited;
    static Point[] start;
    static int answer = Integer.MIN_VALUE;
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M+1]; // 음식물이 있으면 true
        visited = new boolean[N+1][M+1]; // 방문했으면 true
        start = new Point[K];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;
            start[i] = new Point(r,c);
        }

        for (Point p : start) {
            if (!visited[p.r][p.c]){
                int count = BFS(p);
                if(count >= answer) answer = count;
            }
        }

        System.out.println(answer);

    }

    static private int BFS(Point p){
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visited[p.r][p.c] = true;
        int count = 0;

        while(!q.isEmpty()){
            Point thisPoint = q.poll();
            count++;

            for(int i=0; i<4; i++){
                if(i==0 && thisPoint.r <= 1) continue;
                if(i==1 && thisPoint.r >= N) continue;
                if(i==2 && thisPoint.c <= 1) continue;
                if(i==3 && thisPoint.c >= M) continue;

                Point nextPoint = new Point(thisPoint.r+moveRow[i], thisPoint.c+moveCol[i]);
                if(!visited[nextPoint.r][nextPoint.c] && map[nextPoint.r][nextPoint.c]){
                    visited[nextPoint.r][nextPoint.c] = true;
                    q.add(nextPoint);
                }
            }
        }
        return count;
    }
}