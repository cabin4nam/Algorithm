import java.util.*;

class Solution {
    private static int answer;
    private static boolean[] visited;
    private static char[] characters = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        
        answer = 0;
        visited = new boolean[8];
        char[] line = new char[8];
        
        // 모든 순열을 탐색
        makeTeam(0, line, data);
        
        return answer;
    }
    
    public void makeTeam(int depth, char[] line, String[] data){
        if(depth == 8){
            // 조건 확인
            if(isRight(line, data)){
                answer ++;
            };
            
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                line[depth] = characters[i];
                makeTeam(depth + 1, line, data);
                visited[i] = false;
            }
        }
    }
    
    public boolean isRight(char[] line, String[] data){
        Map<Character, Integer> lineMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            lineMap.put(line[i], i);
        }
        
        for(int i=0; i<data.length; i++){
            Character c1 = data[i].charAt(0);
            Character c2 = data[i].charAt(2);
            
            Character operator = data[i].charAt(3);
            int expectedDistance  = Integer.parseInt(data[i].substring(4,5));
            
            int distance = Math.abs(lineMap.get(c1) - lineMap.get(c2)) - 1;
            
            if (operator == '=') {
                if (distance != expectedDistance) return false;
            } else if (operator == '>') {
                if (distance <= expectedDistance) return false;
            } else if (operator == '<') {
                if (distance >= expectedDistance) return false;
            }
        }
        return true;
    }
}