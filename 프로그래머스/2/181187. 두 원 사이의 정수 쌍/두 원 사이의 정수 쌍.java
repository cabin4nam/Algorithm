class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // 좌표 위의 점
        answer += r2-r1+1;
        
        // 사분면 속의 점
       for (int i = 1; i < r2; i++) {
            if (i < r1) {
                answer += getMaxY(i, r2, "r2") - getMaxY(i, r1, "r1");
            } else {
                answer += getMaxY(i, r2, "r2");
            }
        }
        
        return answer*4;
    }
    
    private int getMaxY(long x, long r, String rName) {
        double max = Math.sqrt(r * r - x * x);
        int maxToInt = (int) max;
        if (rName.equals("r1") && max - maxToInt == 0.0) {
            return maxToInt - 1;
        } else {
            return maxToInt;
        }
    }
}