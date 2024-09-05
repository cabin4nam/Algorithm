import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    private static int m;
    private static int max = Integer.MIN_VALUE;

    private static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i,j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int r, int c, int count, int sum){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];

            // 범위 조건 수정
            if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= m){
                continue;
            }

            if(!visited[nextR][nextC]){
                if(count == 2){
                    visited[nextR][nextC] = true;
                    dfs(r, c, count + 1, sum + map[nextR][nextC]); // 'ㅗ' 모양을 만들기 위한 추가 탐색
                    visited[nextR][nextC] = false;
                }

                visited[nextR][nextC] = true;
                dfs(nextR, nextC, count+1, sum+map[nextR][nextC]);
                visited[nextR][nextC] = false;
            }
        }
    }
}
