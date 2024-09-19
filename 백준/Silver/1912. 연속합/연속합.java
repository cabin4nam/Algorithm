import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[] dp;
    private static int max;
    private static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        max = nums[0];

        recur(n-1);

        System.out.println(max);

    }

    private static int recur(int n){
        if(n<0) return 0;
        if(dp[n] == -1){
            dp[n] = Math.max(recur(n-1) + nums[n], nums[n]);

            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}