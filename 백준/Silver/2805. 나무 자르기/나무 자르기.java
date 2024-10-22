import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        int low = 0;
        int high = 0;
        int mid;

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, trees[i]);
        }

        int answer = 0;
        while(low <= high){ // O(logN)
            mid = (low+high)/2;

            long tree = calcLength(trees, mid); // O(N)
            if(tree < M) high = mid-1;
            else{
                low = mid+1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
    
    private static long calcLength(int[] trees, int cut){
        long tree = 0;
        for (int t : trees) {
            if (t > cut) tree += (t - cut);
        }
        
        return tree;
    }
}