import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] warriors;
    static boolean[][] visited;
    static int N; static int M;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        // W가 아군
        // B가 적군

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        warriors = new String[N][M];

        for(int i=0; i<M; i++){
            String warriorsStr = br.readLine();
            for(int j=0; j<N; j++){
                warriors[j][i] = warriorsStr.substring(j, j+1);
            }
        }

        // 우리 팀의 공격력
        visited = new boolean[N][M];
        sum=0;
        int sum_us = 0;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(!visited[n][m] && warriors[n][m].equals("W")){
                    dfs(n, m , "W");
                    sum_us += sum*sum;
                    sum=0;
                }
            }
        }


        // 상대 팀의 공격력
        visited = new boolean[N][M];
        sum = 0;
        int sum_enemy = 0;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(!visited[n][m] && warriors[n][m].equals("B")){
                    dfs(n, m , "B");
                    sum_enemy += sum*sum;
                    sum=0;
                }
            }
        }

        System.out.println(sum_us + " " + sum_enemy);
    }

    public static void dfs(int start_x, int start_y, String flag){
        if(visited[start_x][start_y] || !warriors[start_x][start_y].equals(flag)) return;

        visited[start_x][start_y] = true;
        sum ++;
        // 상
        if(start_y > 0){
            if(warriors[start_x][start_y-1].equals(flag)) {
                dfs(start_x, start_y - 1,  flag);
            }
        }
        // 하
        if(start_y < M-1){
            if(warriors[start_x][start_y+1].equals(flag)) {
                dfs(start_x, start_y + 1, flag);
            }
        }
        // 좌
        if(start_x > 0){
            if(warriors[start_x-1][start_y].equals(flag)) {

                dfs(start_x-1, start_y, flag);
            }
        }
        // 우
        if(start_x < N-1){
            if(warriors[start_x+1][start_y].equals(flag)) {
                dfs(start_x+1, start_y, flag);
            }
        }
    }
}
