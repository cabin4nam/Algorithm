import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> answers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];
        map = new int[n][n];
        answers = new ArrayList<>();

        Queue<Point> hasHome = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str.substring(j, j+1));
                if(map[i][j]==1) hasHome.add(new Point(i,j));
            }
        }

        while(!hasHome.isEmpty()){
            Point start = hasHome.poll();

            if(visited[start.r][start.c]) continue;

            int count = BFS(start);
            answers.add(count);
        }

        Collections.sort(answers);

        System.out.println(answers.size());
        for(int a : answers)
            System.out.println(a);

    }

    private static int BFS(Point p){
        Queue<Point> homeQueue = new LinkedList<>();
        int count = 0;

        homeQueue.add(p);
        visited[p.r][p.c] = true;
        
        while(!homeQueue.isEmpty()){
            Point preHome = homeQueue.poll();
            count++;

            // 위쪽 집 검사
            if(preHome.r > 0){
                if(map[preHome.r-1][preHome.c]==1 && !visited[preHome.r-1][preHome.c]){
                    homeQueue.add(new Point(preHome.r-1, preHome.c));
                    visited[preHome.r-1][preHome.c] = true;
                }
            }

            // 아래쪽 집 검사
            if(preHome.r < map.length-1){
                if(map[preHome.r+1][preHome.c]==1 && !visited[preHome.r+1][preHome.c]){
                    homeQueue.add(new Point(preHome.r+1, preHome.c));
                    visited[preHome.r+1][preHome.c] = true;
                }
            }

            // 왼쪽 집 검사
            if(preHome.c > 0){
                if(map[preHome.r][preHome.c-1]==1 && !visited[preHome.r][preHome.c-1]){
                    homeQueue.add(new Point(preHome.r, preHome.c-1));
                    visited[preHome.r][preHome.c-1] = true;
                }
            }

            // 오른쪽 집 검사
            if(preHome.c < map.length-1){
                if(map[preHome.r][preHome.c+1]==1 && !visited[preHome.r][preHome.c+1]){
                    homeQueue.add(new Point(preHome.r, preHome.c+1));
                    visited[preHome.r][preHome.c+1] = true;
                }
            }
        }

        return count;
    }

}