class Solution {
    private static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        
        goDungeon(k, dungeons, visited, 0);
        
        return answer;
    }
    
    public void goDungeon(int k, int[][] dungeons, boolean[] visited, int count){
        answer = Math.max(answer, count);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true;
                    goDungeon(k-dungeons[i][1], dungeons, visited, count+1);
                    visited[i] = false;
                }
            }
        }
    }
}