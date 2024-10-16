import java.util.*;
import java.io.*;

class Main {
    private static int MAX = 100000;
    private static int N, K;
    private static int[] time;
    private static int minTime = Integer.MAX_VALUE;
    private static int totalCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs(N, K);

        System.out.println(minTime);
        System.out.println(totalCnt);

    }

    private static void bfs(int start, int goal){
        Queue<Integer> q = new LinkedList<>();
        time = new int[MAX+1];
        Arrays.fill(time, -1);

        q.offer(start);
        time[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == goal){
                if(time[now] == minTime) totalCnt ++;
                else if(time[now] < minTime){
                    minTime = time[now];
                    totalCnt =1;
                }
                continue;
            }

            for(int i=0; i<3; i++){
                int next = 0;

                if(i==0) next = now-1;
                else if(i==1) next = now+1;
                else next = now*2;

                if(next < 0 || next > MAX) continue;

                if(time[next] == -1 || (time[next]!=-1 && time[next] >= time[now]+1)){
                    q.add(next);
                    time[next] = time[now]+1;
                }

            }
        }
    }
}