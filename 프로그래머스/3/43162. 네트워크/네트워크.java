import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static boolean[] visited;
    private static int answer = 0;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer ++;
                dfs(computers, n, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int n, int start){
        visited[start] = true;
        
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[start][i]==1) dfs(computers, n, i);
        }
        
        
    }
}