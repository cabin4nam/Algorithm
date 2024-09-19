import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[][] dp;
    private static int[][] paintHome;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집의 개수

        paintHome = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<3; j++){
                // i번째 집을 j번의 색으로 칠하는 비용 (0:빨, 1:초, 2:파)
                paintHome[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        dp[0] = paintHome[0];

        for(int i=0; i<3; i++)
            recur(n-1, i);

        int answer = Integer.MAX_VALUE;
        for(int d : dp[n-1]){
            answer = Math.min(answer, d);
        }
        System.out.println(answer);
    }

    private static int recur(int n, int color){
        if(dp[n][color] == -1){
            // dp[n-1] 중, 현재 채우는 것이 아닌 색 중 최솟값Math.min(dp[n-1][1], dp[n-1][2]);
            dp[n][color] = Math.min(recur(n-1, (color+1)%3), recur(n-1, (color+2)%3)) + paintHome[n][color];
        }

        return dp[n][color];
    }
}