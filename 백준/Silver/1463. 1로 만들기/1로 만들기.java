import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    private static int[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        dp = new int[X+1];
        dp[0] = 0; dp[1] = 0;

        makeOne(X);
        System.out.println(dp[X]);
    }
    public static void makeOne(int n){
        if(n==1){
            dp[1] = 0;
            return ;
        }

        int n1 = MAX_VALUE , n2 = MAX_VALUE, n3 = MAX_VALUE;
        if(n%3==0){
            if(dp[n/3] == 0) makeOne(n/3);

            n1 = 1+dp[n/3];
        }
        if(n%2==0){
            if(dp[n/2] == 0) makeOne(n/2);

            n2 = 1+dp[n/2];
        }

        if(dp[n-1] == 0) makeOne(n-1);
        n3 = 1+dp[n-1];

        dp[n] = Math.min(Math.min(n1, n2), n3);
    }
}