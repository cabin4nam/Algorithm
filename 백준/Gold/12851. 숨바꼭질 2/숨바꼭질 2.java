import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point{
        int p;
        int time;

        public Point(int p, int time){
            this.p = p;
            this.time = time;
        }
    }
    private static int MAX = 100000;
    private static int minTime = Integer.MAX_VALUE;
    private static int totalCnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이
        int K = Integer.parseInt(st.nextToken()); // 동생

        if(N >= K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs(N, K);

        System.out.println(minTime);
        System.out.println(totalCnt);
    }

    private static void bfs(int start, int goal){
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX+1];
        q.offer(new Point(start, 0));
        visited[start] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            visited[p.p] = true;

            if(p.time > minTime) continue;

            if(p.p == goal){
                if(minTime > p.time){
                    minTime = Math.min(minTime, p.time);
                    totalCnt = 0;
                }
                if(minTime == p.time)
                    totalCnt ++;

            }

            // 왼쪽으로 한칸 이동
            if(p.p-1 >= 0 && !visited[p.p-1]) q.offer(new Point(p.p-1, p.time + 1));

            // 오른쪽으로 한칸 이동
            if(p.p+1 <= MAX && !visited[p.p+1]) q.offer(new Point(p.p+1, p.time + 1));

            // 순간이동
            if(p.p*2 <= MAX && !visited[p.p*2]) q.offer(new Point(p.p*2, p.time + 1));

        }

    }
}