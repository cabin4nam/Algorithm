class Solution {
    static boolean[] visited;
    static int answer = 0;
    static String[] eng = {"A", "E", "I", "O", "U"};
    static boolean isFound = false;
    public int solution(String word) {
        
        visited = new boolean[word.length()];
        
        for(int i=0; i<5; i++){
            if(isFound) break;
            
            DFS(word, eng[i]);
        }
        
        return answer;
    }
    
    private void DFS(String word, String str){
        if(str.length() > 5) return;
        
        answer++;
        if(str.equals(word)){
            isFound = true;
            return;
        } 
         
        for(int i=0; i<5; i++){
            if(isFound) break;
            
            DFS(word, str+eng[i]);
            
        }
    }
    
}