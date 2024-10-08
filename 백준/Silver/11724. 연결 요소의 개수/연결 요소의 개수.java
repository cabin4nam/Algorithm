import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] graph;
    private static boolean[] visited;
    private static StringBuilder dfsResult = new StringBuilder();
    private static StringBuilder bfsResult = new StringBuilder();
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 그래프 표현
        graph = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = graph[n2][n1] = 1;
        }

        visited = new boolean[N+1];

        int answer = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                answer ++;
            }
        }

        System.out.println(answer);


    }

    private static void dfs(int node) {
        visited[node] = true;

        dfsResult.append(node).append(" ");

        for (int next = 1; next <= N; next++) {
            if (graph[node][next] == 1 && !visited[next]) dfs(next);
        }
    }

}