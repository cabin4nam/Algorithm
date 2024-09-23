import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[][] map, dp;
    private static int n, m;
    private static final int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로 길이
        m = Integer.parseInt(st.nextToken()); // 가로 길이

        map = new int[n][m];
        dp = new int[n][m];  // dp[i][j]: (i, j)에서 목표 지점까지 갈 수 있는 경로 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // -1로 초기화 (아직 방문하지 않은 상태)
            }
        }

        // (0, 0)에서 (n-1, m-1)까지의 경로 수를 출력
        System.out.println(dfs(0, 0));
    }

    // DFS를 이용하여 경로 탐색
    private static int dfs(int x, int y) {
        // 목표 지점에 도착한 경우 경로 수 1 반환
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        // 이미 계산된 경로 수가 있는 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 경로 수를 0으로 초기화하고 시작

        // 상하좌우로 이동하면서 경로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위 내에 있고, 내리막길인 경우에만 이동
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y]; // (x, y)에서 목표 지점까지의 경로 수 반환
    }
}
