import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int M;
    static int[] volume;
    static boolean[][] dp;
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volume = new int[N+1];
        dp = new boolean[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            volume[i] = Integer.parseInt(st.nextToken());
        }

        if(S-volume[1] >= 0) dp[1][S-volume[1]] = true;
        if(S+volume[1] <= M) dp[1][S+volume[1]] = true;

        for(int i=1; i<N; i++){
            for(int j=0; j<= M; j++){
                if(!dp[i][j]) continue;

                if(j-volume[i+1] >= 0) dp[i+1][j-volume[i+1]] = true;
                if(j+volume[i+1] <= M) dp[i+1][j+volume[i+1]] = true;
            }
        }

        for(int i=0; i<=M; i++){
            if(dp[N][i] && i>max) max = i;
        }

        System.out.println(max);


    }
}