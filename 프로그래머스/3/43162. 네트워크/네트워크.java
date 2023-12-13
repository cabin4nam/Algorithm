class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[computers.length];
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                answer ++;
                dfs(computers, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int start){
        visited[start] = true;
        
        for(int i=0; i<computers[start].length; i++){
            System.out.println(computers[start][i]);
            if(visited[i]) continue;
            if(start == i) continue;
            
            if(computers[start][i] == 1) dfs(computers, i);
        }
    }
}