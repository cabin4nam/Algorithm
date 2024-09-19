import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] dp ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        dp = new int[1000001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // -1 로 초기화
        for(int i = 3; i <= n; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(n));
    }

    private static int Tile(int n){
        if(dp[n] == -1){
            dp[n] = (Tile(n - 1) + Tile((n - 2))) % 15746;
        }
        return dp[n];
    }
}