import java.io.*;
import java.util.*;
public class Main{
    private static int N;
    private static int S;
    private static int M;
    private static int[] gap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 곡의 개수
        S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // 최대 볼륨

        gap = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) gap[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N+1][M+1];
        for(boolean[] d : dp) Arrays.fill(d, false);

        dp[0][S] = true;
        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i-1][j]){
                    if(j + gap[i] <= M) dp[i][j+gap[i]] = true;
                    if(j - gap[i] >= 0) dp[i][j-gap[i]] = true;
                }
            }
        }

        for(int i=M; i>=0; i--){
            if(dp[N][i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}