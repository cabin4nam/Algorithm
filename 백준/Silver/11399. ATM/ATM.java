import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        // times를 오름차순 정렬
        Arrays.sort(times);

        // 누적합 구하기
        int[] sum = new int[N+1];
        sum[0] = times[0];
        for(int i=1; i<times.length; i++){
            sum[i] = sum[i-1]+times[i];
        }

        int answer = 0;
        for(int s : sum) answer+=s;

        System.out.println(answer);
    }

}