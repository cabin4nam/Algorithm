import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int mid = 0;
        
        while(left <= right){
            mid = (left+right)/2;
            
            if(removeRockCnt(rocks, mid, distance) <= n){
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return answer;
    }
    
    private static int removeRockCnt(int[] rocks, int mid, int distance){
        // mid가 바위(지점) 간 최소 거리가 되어야 함
        // 그렇게 되도록 하기 위해 제거해야 할 바위의 개수 구하기
        
        int start = 0;
        int end = distance;
        
        int removeCnt = 0;
        
        for(int i=0; i<rocks.length; i++){
            if(rocks[i]-start < mid){ // 제거
                removeCnt ++;
            }
            else{
                start = rocks[i];
            }
        }
        
        if(end-start < mid) removeCnt++;
        
        return removeCnt;
    }
}