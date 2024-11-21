import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    private static int[][] move = {{-1, 0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1, -1}, {0,-1}, {-1,-1}};
    private static class Point{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        // 얘가 킥임 !!!!!
        public int hashCode() {
            return Objects.hash(r,c);
        }

        public boolean equals(Object o) {
            return this.r == ((Point) o).r && this.c == ((Point) o).c;
        }
        
    }
    public int solution(int[] arrows) {
        int answer = 0;
        
        /* 
        방이 만들어지는 경우 : 방문했던 정점을 다시 방문하는 경우
            - 근데 방문했던 정점을 기존에 방문했던 간선을 통해서 방문한 경우는 제외 (이미 세아린 경우일 것이기 때문)         */
        
        HashMap<Point, ArrayList<Point>> map = new HashMap<>();
        
        Point nowPoint = new Point(0,0);
        map.put(nowPoint, new ArrayList<Point>());
        
        for(int a : arrows){
            for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업(반복 2번)
                int nextR = nowPoint.r + move[a][0];
                int nextC = nowPoint.c + move[a][1];
                Point nextPoint = new Point(nextR, nextC);

                // 다음으로 이동할 정점에 방문한 적 없으면
                if(!map.containsKey(nextPoint)){
                    // 리스트에 연결점 추가
                    map.put(nextPoint, new ArrayList<Point>());
                    
                    // 현재 정점과의 간선 추가
                    map.get(nowPoint).add(nextPoint);
                    map.get(nextPoint).add(nowPoint);
                }
                // 다음으로 이동할 정점에 방문한 적이 있고, nowPoint-nextPoint 간선으로 이동한 적이 없는 경우 
                // -> 방이 만들어짐
                else if(map.containsKey(nextPoint) && !map.get(nextPoint).contains(nowPoint)){
                    map.get(nowPoint).add(nextPoint);
                    map.get(nextPoint).add(nowPoint);
                    answer++;
                }
                
                nowPoint = nextPoint;
            }
        }
        
        return answer;
    }
}
