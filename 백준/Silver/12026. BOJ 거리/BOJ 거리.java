import java.io.*;
import java.util.*;

public class Main{
    private static HashMap<Character, Integer> boj = new HashMap<>() {{
        put('B', 0);
        put('O', 1);
        put('J', 2);
    }};
    private static int[] dp;
    private static char[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        map = new char[n+1];
        String str = br.readLine();
        for(int i=1; i<=n; i++) map[i] = str.charAt(i-1);

        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i=1; i<=n; i++){
            // 다음에 와야 할 문자 (현재 문자가 B라면 O, J라면 B)가 있는 곳에 dp 갱신해주기
            if(dp[i] == -1) continue;

            int next = (boj.get(map[i])+4)%3;

            for(int j=i+1; j<=n; j++){
                if(next == boj.get(map[j])){
                    if(dp[j] == -1) dp[j] = dp[i]+((j-i) * (j-i));
                    else dp[j] = Math.min(dp[j], (dp[i]+((j-i) * (j-i))));
                }
            }
        }

        System.out.println(dp[n]);
    }

}