import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int minTime = Integer.MAX_VALUE;
    static final int MAX = 100000;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[MAX+1];
        Arrays.fill(parent, -1);
        bfs(N, K);

        StringBuilder sb = new StringBuilder();
        sb.append(minTime).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(K);

        while(true){
            int next = stack.peek();
            if(parent[next] == -1) break;
            stack.push(parent[next]);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(int start, int goal) {
        int[] time = new int[MAX+1];
        Arrays.fill(time, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == goal){
                minTime = Math.min(minTime, time[now]);
                return;
            }

            for(int i=0; i<3; i++){
                int next;

                if(i==0) next = now*2;
                else if(i==1) next = now+1;
                else next = now-1;

                if(next < 0 || next > MAX) continue;

                if(time[next]==-1 || time[next] > time[now]+1){
                    q.offer(next);
                    time[next] = time[now]+1;
                    parent[next] = now;
                }
            }
        }
    }
}