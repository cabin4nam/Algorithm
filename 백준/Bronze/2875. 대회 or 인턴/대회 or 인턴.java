import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken()); // 여학생 수
        int M = Integer.parseInt(st.nextToken()); // 남학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야하는 인원수

        while(N>=2 && M>=1){
            N = N-2;
            M = M-1;

            if(N+M < K){
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }
}