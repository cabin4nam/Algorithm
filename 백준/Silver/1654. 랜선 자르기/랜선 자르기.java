import java.io.*;
import java.util.*;

public class Main{
    private static int[] wires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long answer = 0;

        long low = 0;
        long high = 0;
        long mid;

        wires = new int[K];
        for(int i=0; i<K; i++){
            wires[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, wires[i]);
        }

        high ++;

        while(low < high){
            mid = (low+high)/2;

            // mid의 길이로 잘랐을 때 얻을 수 있는 랜선의 개수 구하기
            int count = countWires(mid);

            if(count < N) high = mid;
            else{
                low = mid+1;
            }
        }

        System.out.println(low-1);

    }

    private static int countWires(long mid){
        int count = 0;
        for(int w : wires){
            count += w/mid;
        }

        return count;
    }
}