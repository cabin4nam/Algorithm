import java.io.*;
import java.util.*;

public class Main {
    static int[][] DP;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        DP = new int[N+1][K+1];
        for(int i=0; i<=N; i++){
            for(int j =0; j<=K; j++){
                DP[i][j] = -1;
            }
        }
        if(K==0 || N==1 || N==K) System.out.println(1);
        else System.out.println(pickItem(N,K));
    }

    private static int pickItem(int N, int K){
//        if(DP[N][K] != -1) return DP[N][K];
        if(N==K){
            DP[N][K] = 1;
            return 1;
        }
        if(K==1) {
            DP[N][K] = N;
            return N;
        }

        return pickItem(N-1, K-1) + pickItem(N-1, K);
    }

}