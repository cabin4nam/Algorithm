// 다익스트라 문제 풀기
/**
1. 변수 : List<int[]>[] graph(초기에 주어지는 간선 정보)
          int[] dist (출발점부터 각 점까지의 최단 거리)
          boolean[] visited(방문 검사)
2. 함수 : PriorityQueue 이용
**/
import java.util.*;
class Solution {
    private static List<int[]>[] graph;
    private static int[] dist;
    private static boolean[] visited;
    private static int INF = Integer.MAX_VALUE;
    private static int size;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        size = N;
        // 변수 초기화
        graph = new ArrayList[N + 1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        
        Arrays.fill(dist, INF);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            int h1 = road[i][0];
            int h2 = road[i][1];
            int c = road[i][2];
            
            graph[h1].add(new int[]{h2, c});
            graph[h2].add(new int[]{h1, c});
        }
        
        // 다익스트라 알고리즘 (출발점 : 1)
        dijkstra(1);
        
        for(int i=1; i<=size; i++){
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
    
    public void dijkstra(int start){
        // 우선순위 큐 -> 비용 기준으로 최소힙으로 만들어줌 (a[1]-b[1])
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        dist[start] = 0;
        pq.add(new int[]{start, 0}); // 시작점부터 int[0]점까지 int[1]의 비용 발생
        
        while(!pq.isEmpty()){
            int currNode = pq.poll()[0]; // 가장 비용이 적은 요소 꺼내기 (힙 성질)
            if(visited[currNode]) continue;
            
            visited[currNode] = true;
            
            for(int[] next : graph[currNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                
                // start에서 바로 nextNode로 가는 것보다, start->currNode->nextNode가 더 빠를 경우 갱신
                if(dist[nextNode] > dist[currNode] + nextCost){
                    dist[nextNode] = dist[currNode]+nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        
        
    }
}