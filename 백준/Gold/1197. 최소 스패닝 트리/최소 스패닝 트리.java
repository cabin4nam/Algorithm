import java.io.*;
import java.util.*;

// 프림 알고리즘
public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static ArrayList<Node>[] graph;
    static Boolean[] visited;
    static int minCost =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프를 나타낼 자료구조
        graph = new ArrayList[V+1];
        for(int i=1; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new Boolean[V+1];
        Arrays.fill(visited, false);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }


        // 오름차순 정렬을 하여 가장 작은 간선부터 연결하기 위해 우선순위 큐 활용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int to = n.node;
            int cost = n.cost;

            if(visited[to]) continue;
            visited[to] = true;
            minCost += cost;

            for(Node next : graph[to]) {
                if(!visited[next.node]) pq.add(next);
            }
        }

        System.out.println(minCost);
    }
}