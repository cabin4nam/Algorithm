import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] originNums2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            originNums2[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums2 = new int[M];
        for(int i=0; i<M; i++){
            nums2[i] = originNums2[i];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashMap<Integer, Integer> map = new HashMap<>();

        int index1 = 0;
        int index2 = 0;

        while(true){
            if(index1 >= N) break;
            if(index2 >= M) break;

            if(nums1[index1] == nums2[index2]){
                map.put(nums2[index2], 1);
                index2 ++;
            }
            else if(nums1[index1] < nums2[index2]){
                index1 ++;
            }
            else if(nums1[index1] > nums2[index2]){
                index2 ++;
            }
        }

        for(int i=0; i<M; i++){
            if(map.get(originNums2[i]) == null) System.out.println(0);
            else System.out.println(map.get(originNums2[i]));
        }
    }
}