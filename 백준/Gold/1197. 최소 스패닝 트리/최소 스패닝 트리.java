import java.io.*;
import java.util.*;

// 프림 알고리즘
public class Main {
    static class Node{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Node> graph;
    static Boolean[] visited;
    static int[] parents;
    static int count=0;
    static int minCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프를 나타낼 자료구조
        graph = new ArrayList<>();
        parents = new int[V+1];
        for(int i=0; i<parents.length; i++){
            parents[i] = i;
        }
        visited = new Boolean[V+1];
        Arrays.fill(visited, false);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(start, end, cost));
        }

        // cost를 기준으로 오름차순 정렬
        Collections.sort(graph, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.cost == n2.cost) return 0;
                else if(n1.cost > n2.cost) return 1;
                else return -1;
            }
        });

        for(Node n : graph){
            // n.from과 n.to를 연결하면 고리가 만들어지는가??
            if(union(n.from, n.to)){
                minCost += n.cost;
                count++;

                // 모두 다 연결했으면
                if(count == E-1) break;
            }
        }

        System.out.println(minCost);
    }

    // from 과 to가 결국은 연결되어 있는가? -> 사이클이 존재하는가?
    // 결국 연결 (사이클 존재) 되어있으면 -> 둘을 연결하지 말고 false 리턴
    // 연결되어 있지 않으면 (사이클 존재X) -> 둘을 연결하고 (root 통일) true 리턴
    private static boolean union(int from, int to){
        int fromRoot = findSet(from);
        int toRoot = findSet(to);

        if(fromRoot == toRoot) return false;
        else parents[toRoot] = fromRoot;

        return true;
    }

    private static int findSet(int v){
        if(parents[v] == v) return v;
        else return parents[v] = findSet(parents[v]);
    }
}