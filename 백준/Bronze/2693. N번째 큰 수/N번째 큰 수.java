import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t =0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer[] nums = new Integer[10];

            for(int i=0; i<10; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums, Collections.reverseOrder());

            System.out.println(nums[2]);
        }
    }

}
