import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = -1;
    static long startNum;
    static long endNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        startNum = Long.parseLong(st.nextToken());
        endNum = Long.parseLong(st.nextToken());

        DFS(startNum, 0);

        System.out.println(answer);
    }
    private static void DFS(long num, int depth){
        if(num > endNum) return;
        if(num == endNum){
            if(answer == -1 || answer > (depth+1)) answer = depth+1;
            return;
        }

        DFS(num*2, depth+1);
        DFS(num*10 + 1, depth+1);
    }
}