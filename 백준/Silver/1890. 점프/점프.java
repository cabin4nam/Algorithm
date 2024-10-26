import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0) break;

                // 아래쪽으로 가는 경우
                int down = i+map[i][j];
                if(down < n) dp[down][j] += dp[i][j];

                // 오른쪽으로 가는 경우
                int right = j+map[i][j];
                if(right < n) dp[i][right] += dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
}