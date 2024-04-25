import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    private static int[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int n = sc.nextInt();

            dp = new int[12];

            plusNum(n);
        }
    }

    public static void plusNum(int n){
        if(n<=0) return;

        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if(n<4) {
            System.out.println(dp[n]);
        }
        else {
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[n]);
        }

    }
}