import java.util.*;
class Solution {
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static int answer = 0;
    private static Map<Integer, Integer> count;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        graph = new List[n+1];
        count = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        findMax(1);
        
        int max = -1;
        for(int key : count.keySet()){
            if(key > max) max = key;
        }
        answer = count.get(max);
        
        return answer;
    }
    
    public void findMax(int start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;
        count.put(0, count.getOrDefault(0, 0) +1);
        
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int next : graph[curr[0]]){
                if(!visited[next]){
                    q.offer(new int[]{next, curr[1]+1});
                    visited[next] = true;
                    count.put(curr[1]+1, count.getOrDefault(curr[1]+1, 0) +1);
                }
            }
        }
        
    }
}