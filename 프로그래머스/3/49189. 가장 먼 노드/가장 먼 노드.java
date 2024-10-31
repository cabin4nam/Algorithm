import java.util.*;
class Solution {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] distance;
    private static int answer;
    private static class Node{
        int node;
        int depth;
        public Node(int node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int solution(int n, int[][] edge) {
        answer = 0;
        
        // 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지 구하기
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        // 그래프 표현
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int[] e : edge){
            int n1 = e[0];
            int n2 = e[1];
            
            if(graph[n1] == null) graph[n1] = new ArrayList<Integer>();
            if(graph[n2] == null) graph[n2] = new ArrayList<Integer>();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        // 1-> 2,3
        // 2-> 1,3,4,5
        // 3-> 1,4,6
        // 4-> 2,3
        // 5-> 2
        // 6-> 3
        
        bfs(1);      
        return answer;
    }
    
    private static void bfs(int node){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(node, 1));
        visited[node] = true;
        
        int maxDepth = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(maxDepth == now.depth) answer++; // 최대 길이 노드라면 answer++;
			else if (maxDepth < now.depth) { // 더 긴 거리에 노드가 있다면 answer = 1, MaxDepth 갱신
				maxDepth = now.depth;
				answer = 1;
			}
            
            for(int next : graph[now.node]){
                if(!visited[next]){
                    q.offer(new Node(next, now.depth+1));
                    visited[next] = true;
                }
            }
        }
    }
}