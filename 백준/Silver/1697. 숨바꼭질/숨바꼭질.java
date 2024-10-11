import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static int[] count = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

       if(N==K) System.out.println(0);
       else bfs(N);

    }

    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        count[n] = 1;

        while(!q.isEmpty()){
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(count[temp]);
                    return;
                }

                if (next >= 0 && next < count.length && count[next] == 0) {
                    q.add(next);
                    count[next] = count[temp] + 1;
                }
            }
        }
    }
}