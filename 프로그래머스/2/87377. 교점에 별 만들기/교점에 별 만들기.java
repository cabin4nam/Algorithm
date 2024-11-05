import java.util.*;
class Solution {
    private static class Point{
        long x;
        long y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    public String[] solution(int[][] line) {
        String[] answer;
        
        String[][] temp;
        
        
        ArrayList<Point> points = new ArrayList<>();
        // 교점 구하기
        for(int i = 0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                Point inter = findIntersection(line[i], line[j]);
                
                if(inter != null) points.add(inter);
            }
        }
        
        // x의 최댓값과 최솟값 구하기
        long maxX = Long.MIN_VALUE; long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE; long minY = Long.MAX_VALUE;
        for(Point p : points){
            if(maxX < p.x) maxX = p.x;
            if(minX > p.x) minX = p.x;
            
            if(maxY < p.y) maxY = p.y;
            if(minY > p.y) minY = p.y;
        }
        
        answer = new String[(int)(maxY-minY+1)];
        temp = new String[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(String[] a : temp) Arrays.fill(a, ".");
        for(Point p : points){
            temp[(int)(maxY-p.y)][(int)(p.x-minX)] = "*";
        }
        
        
        for(int i =0; i<temp.length; i++){
            StringBuilder sb = new StringBuilder();
            for(String str : temp[i])
                sb.append(str);
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private static Point findIntersection(int[] line1, int[] line2){
        long a1 = line1[0]; long b1 = line1[1]; long c1 = line1[2];
        long a2 = line2[0]; long b2 = line2[1]; long c2 = line2[2];
        
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);
        
        if(x%1!= 0 || y%1!=0) return null;
        
        return new Point((long)x,(long)y);
    }
}