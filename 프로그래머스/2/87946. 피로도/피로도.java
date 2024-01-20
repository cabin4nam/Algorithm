class Solution {
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        for(int i=0; i<dungeons.length; i++){
            visited[i] = true;
            adventure(k-dungeons[i][1], dungeons, 1);
            visited[i] = false;
        }
        
        return answer;
    }
    
    private void adventure(int px, int[][] dungeons, int count){
        boolean canGo = false;
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            
            if(px >= dungeons[i][0]){
                canGo = true;
                visited[i] = true;
                adventure(px-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            } 
        }
        
        if(!canGo){
            if(answer < count) answer = count;
            return;
        } 
        
    }
}