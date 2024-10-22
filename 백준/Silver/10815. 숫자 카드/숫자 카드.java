import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Long.parseLong(st.nextToken());

        Arrays.sort(nums);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        long[] targets = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) targets[i] = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            int low = 0;
            int high = N-1;
            int mid;

            boolean hasFound = false;
            while(low <= high){
                mid = (low+high)/2;

                if(nums[mid] == targets[i]){
                    hasFound = true;
                    break;
                }
                else if(nums[mid] < targets[i]) low = mid+1;
                else high = mid-1;
            }

            if(hasFound) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}