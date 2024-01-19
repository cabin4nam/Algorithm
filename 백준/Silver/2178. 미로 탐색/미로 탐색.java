import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point{
        int row;
        int col;

        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N+1][M+1]; // 문제에서 주어진 미로를 표현하기 위한 배열
        int[][] bfs = new int[N+1][M+1]; // 각 위치까지의 위치를 저장하기 위한 배열
        boolean[][] visited = new boolean[N+1][M+1]; // 방문 배열
        Queue<Point> q = new LinkedList<>(); // 각 위치에서 이동할 수 있는 Point를 저장

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(str.substring(j-1,j));
            }
        }

        // 초기 설정 - (1,1)에서 시작
        q.add(new Point(1,1));
        bfs[1][1] = 1;
        visited[1][1] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            // (N,M)에 도착하면 출력, 반복문 탈출(종료)
            if(p.row == N && p.col == M){
                System.out.println(bfs[p.row][p.col]);
                break;
            }

            // 상 하 좌 우 위치를 검사
            for(int i=0; i<4; i++){
                if(i==0 && p.row <= 1) continue; // row -1
                else if(i==1 && p.row >= N) continue; // row+1
                else if(i==2 && p.col <= 1) continue; // col -1
                else if(i==3 && p.col >= M) continue; // col+1

                int nextRow = p.row+moveRow[i];
                int nextCol = p.col+moveCol[i];

                // 방문한 적이 없고, 갈 수 있는 (maze가 1이면) 위치면 
                // 큐에 저장, 방문 배열 true로 갱신, bfs 배열에 이동횟수 저장
                if(!visited[nextRow][nextCol] && maze[nextRow][nextCol]==1){
                    visited[nextRow][nextCol] = true;
                    bfs[nextRow][nextCol] = bfs[p.row][p.col] + 1;
                    q.add(new Point(nextRow, nextCol));
                }
            }
        }

    }
}