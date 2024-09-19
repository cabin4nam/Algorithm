import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[][] triangle;
    private static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 삼각형의 크기

        triangle = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        dp[0][0] = triangle[0][0];

        for(int i=0; i<n; i++)
            recur(n-1, i);

        int answer = Integer.MIN_VALUE;
        for(int d : dp[n-1]){
            answer = Math.max(answer, d);
        }

        System.out.println(answer);

    }

    private static int recur(int r, int c){
        if(dp[r][c] == -1){
            if(c==0)
                dp[r][c] = recur(r-1, c) + triangle[r][c];
            else if(c==r)
                dp[r][c] = recur(r-1, c-1) + triangle[r][c];
            else
                dp[r][c] = Math.max(recur(r-1, c) , recur(r-1, c-1)) + triangle[r][c];
        }

        return dp[r][c];
    }

}