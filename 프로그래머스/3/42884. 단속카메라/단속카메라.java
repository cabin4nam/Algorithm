import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 시작하는 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, (int[] r1, int[] r2) -> r1[1] - r2[1]);
        
        int hasCamera = routes[0][1];
        answer ++;
        for(int i=1; i<routes.length; i++){
            if(routes[i][0] > hasCamera) {
                answer++;
                hasCamera = routes[i][1];
            }
        }
        
        return answer;
    }
}