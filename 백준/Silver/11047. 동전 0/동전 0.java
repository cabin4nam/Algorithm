import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i=0; i<n; i++) coins[i] = Integer.parseInt(br.readLine());

        for(int i=n-1; i>=0; i--){
            int coin = coins[i];

            if(coin > k) continue;

            answer += k/coin;
            k %= coin;
        }

        System.out.println(answer);
    }
}