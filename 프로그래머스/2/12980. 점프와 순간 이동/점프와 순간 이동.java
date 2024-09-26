// // 현재+K (K만큼의 전지 사용 O), 현재x2(전지 사용 X) 위치로 이동
// import java.util.*;

// public class Solution {
//     private static int[] dp;
//     public long solution(int n) {
//         long ans = 0;

//         if(n<=1) return 1;
        
//         dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 1;
        
        
//         ans = recur(n);
        
//         return ans;
//     }
    
//     public int recur(int n){
//         if(n == 0) return 0;
//         else if(n<=2) return 1;
        
//         if(dp[n] == -1){
//             if(n%2==0) dp[n] = Math.min(recur(n-1)+1, recur(n/2));
//             else dp[n] = recur(n-1)+1;
//         }
        
//         return dp[n];
//     }
// }

public class Solution {
    public long solution(int n) {
        long ans = 0;

        while (n > 0) {
            // N이 홀수라면 1을 빼서 건전지 사용량을 늘리고, N을 짝수로 만듦
            if (n % 2 == 1) {
                ans++;
                n--;
            }
            // N이 짝수일 경우 순간이동: 2로 나누기 (건전지 사용량 변동 없음)
            n /= 2;
        }

        return ans;
    }
}
