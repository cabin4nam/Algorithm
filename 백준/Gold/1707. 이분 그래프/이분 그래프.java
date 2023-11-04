import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            graph = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;

            for(int i=1; i<=V; i++){
                graph[i] = new ArrayList<Integer>();
            }
            // 에지 데이터 저장하기
            for(int i=0; i<E; i++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[01]);

                graph[start].add(end);
                graph[end].add(start);
            }
            
            //모든 노드에 대해서 DFS 실행
            for(int i=1; i<=V; i++){
                if(isEven){
                    DFS(i);
                }
                else break;
            }

            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static void DFS(int start){
        visited[start] = true;
        for(int i : graph[start]){ // 인접리스트로 받아서 start에 연결된 모든 노드에 대해서 진행
            // 바로 직전에 있는 노드와 다른 집합으로 분류해주는 것이 필요
            if(!visited[i]){
                check[i] = (check[start] + 1)%2;
                DFS(i);
            }
            else if(check[start] == check[i]){
                isEven = false;
            }
        }
    }

}