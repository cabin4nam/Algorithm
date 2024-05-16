import java.util.*;
class Solution {
    private static final int[] moveX = {0, 0, 1, -1};
    private static final int[] moveY = {-1, 1, 0, 0};
    
    public int solution(String dirs) {
        
        int preX = 5;
        int preY = 5;
        
        HashSet<String> answer = new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            int dir = -1;
            switch(dirs.substring(i, i+1)){
                case "U" : dir = 0; break;
                case "D" :dir = 1; break;
                case "R" : dir = 2; break;
                case "L" : dir = 3; break;
            }
            // 이동
            int nextX = preX + moveX[dir];
            int nextY = preY + moveY[dir];
            
            if(nextX >= 0 && nextX <= 10 && nextY >= 0 && nextY <= 10){
                // 방문 경로를 answer에 저장
                answer.add(preX + " " + preY + " " + nextX + " " + nextY);
                answer.add(nextX + " " + nextY + " " + preX + " " + preY);
                
                preX = nextX;
                preY = nextY;
            }
            else continue;
            
            
        }
        
        return answer.size()/2;
    }
}