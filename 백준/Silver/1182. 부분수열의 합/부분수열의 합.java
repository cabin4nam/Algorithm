import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int S;
    private static int[] nums;
    private static int answer = 0;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        for(int start=0; start<N; start++){
            for(int count=1; count<=N; count++){
                countSum(count, start, 1, nums[start]);
            }
        }

        System.out.println(answer);

    }
    private static void countSum(int count, int start, int depth, int sum){
        if(count == depth){
            if(sum == S) answer ++;
            return;
        }

        for(int i=start+1; i<N; i++){
            countSum(count, i, depth+1, sum+nums[i]);
        }
    }
}