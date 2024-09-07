// m : 가로길이 , n : 세로길이
// 시작 위치 : startX, startY
// 목표 위치 : balls (x : [0], y : [1])
// 머쓱이가 공을 적어도 벽에 한 번은 맞춘 후 목표 공에 맞힌다고 할 때, 각 회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int m, int n, int startX, int startY, int[][] balls) {
        ArrayList<Integer> answer = new ArrayList<>(balls.length);
        
        int[][] board = new int[m][n];
        
        for(int i=0; i<balls.length; i++){
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            
            
            int minDistance = Integer.MAX_VALUE;
            
            // 위쪽 방향으로 보내기
           if(startX != ballX || startY > ballY) 
                minDistance = Math.min(calcDistance(startX, startY, ballX, (n+(n-ballY))), minDistance);
            
            // 아래쪽 방향으로 보내기
            if(startX != ballX || startY < ballY) 
                minDistance = Math.min(calcDistance(startX, startY, ballX, -ballY), minDistance);   
            // 왼쪽 방향으로 보내기
            if(startY != ballY || startX < ballX) 
                minDistance = Math.min(calcDistance(startX, startY, -ballX, ballY), minDistance); 
            // 오른쪽 방향으로 보내기
            if(startY != ballY || startX > ballX) 
                minDistance = Math.min(calcDistance(startX, startY, (m+(m-ballX)), ballY), minDistance);   
            // 최소가 되는 거리를 저장
            answer.add(minDistance);
        }
        
        return answer;
    }
    
    private static int calcDistance(int x1, int y1, int x2, int y2){ 
        return (int)(Math.pow((x1-x2), 2)) + (int)(Math.pow((y1-y2), 2));
    }
}