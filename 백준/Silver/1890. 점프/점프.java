import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());

       map = new int[N][N];
       dp = new long[N][N];
       for(int i=0; i<N; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=0; j<N; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
               dp[i][j] = 0;
           }
       }
       
        dp[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==N-1 && j==N-1) continue; //도착 지점
                int next = map[i][j];
                if(i+next < N) dp[i+next][j] += dp[i][j]; // 세로이동 (아래로 이동)
                if(j+next < N) dp[i][j+next] += dp[i][j]; // 가로이동 (오른쪽으로 이동)
            }
        }
        System.out.println(dp[N-1][N-1]);

    }
}