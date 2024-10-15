import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] nums;
    private static boolean[] visited;
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        set = new HashSet<>();
        back(0, "");
        System.out.println(sb.toString());

    }

    private static void back(int depth, String result){
        if(depth == M){
            if(!set.contains(result)){
                set.add(result);

                sb.append(result).append("\n");  // 수열을 출력
            }

            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                String next = result+nums[i]+" ";

                back(depth+1, next);

                visited[i] = false;
            }
        }

    }
}