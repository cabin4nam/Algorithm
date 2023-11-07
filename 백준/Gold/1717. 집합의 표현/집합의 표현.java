import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        for(int i =0; i<n+1; i++){
            nums[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){ // union
                if(a==b) continue;
                union(a, b);
            }
            else { // find
                if(a==b){
                    System.out.println("YES");
                    continue;
                }

                int rootA = find(a);
                int rootB = find(b);

                if(rootA == rootB) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static int find(int a){
        if(nums[a] == a) return a;
        return nums[a] = find(nums[a]);
    }

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        nums[rootA] = rootB;
    }
}