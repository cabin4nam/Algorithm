import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // map 초기화
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        // 방문하지 않은 단지에서 시작해 dfs 탐색
        ArrayList<Integer> answer = new ArrayList<>();
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a : answer) System.out.println(a);

    }

    private static void dfs(int r, int c) {
        count ++;
        visited[r][c] = true;

        // 상하좌우로 이동
        for(int i=0; i<4; i++){
            int nextR = r+move[i][0];
            int nextC = c+move[i][1];

            if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;
            if(visited[nextR][nextC]) continue;

            if(map[nextR][nextC] == 1){
                dfs(nextR, nextC);
            }
        }
    }

}