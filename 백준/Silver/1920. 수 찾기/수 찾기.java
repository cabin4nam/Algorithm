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

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        long[] targets = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) targets[i] = Long.parseLong(st.nextToken());

        // nums 정렬
        Arrays.sort(nums);

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

            if (hasFound) System.out.println(1);
            else System.out.println(0);

        }
    }
}