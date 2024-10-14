import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        back(0);

        System.out.println(sb.toString());
        
    }

    private static void back(int depth){
        if(depth == M){
            // arr에 있는 값을 저장
            for(int s : arr) sb.append(s + " ");
            sb.append("\n");

            return;
        }

        for(int i=1; i<=N; i++){
            arr[depth] = i;
            back(depth+1);
        }
    }
}