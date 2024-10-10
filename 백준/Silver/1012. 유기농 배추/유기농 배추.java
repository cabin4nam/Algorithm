import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            int answer = 0;

            map = new int[N][M];
            visited = new boolean[N][M];
            
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!visited[i][j] && map[i][j] ==1){
                        answer ++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    private static void dfs(int r, int c){

        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];

            if(nextR <0 || nextC < 0 || nextR >= N || nextC >= M) continue;
            if(visited[nextR][nextC]) continue;

            if(map[nextR][nextC] == 1) dfs(nextR, nextC);
        }
    }


}