import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        if(n < 3){
            int answer = 0;
            for(int i=0; i<n; i++){
                answer += stairs[i];
            }
            System.out.println(answer);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0], stairs[1]) + stairs[2];

        for(int i=3; i<n; i++){
            // 직전(i-1) 계단을 밟고,그 전 계단을 밟지 않는 경우 (dp[i-3])
            // 직전(i-1) 계단을 밟지 않고, 그 전 계단을 밟는 경우 (dp[i-2])

            dp[i] = Math.max(stairs[i-1] + dp[i-3], dp[i-2]) + stairs[i];
        }

        System.out.println(dp[n-1]);
    }
}