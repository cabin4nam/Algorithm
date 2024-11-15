import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        int mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            
            int count = removeRock(rocks, mid, distance);
        
            if(count > n){
                right = mid-1;
                
            }
            else{
                answer = mid;
                left = mid+1;
                
            }
        }
        
        return answer;
    }
    
    private static int removeRock(int[] rocks, int mid, int distance){
        int count = 0; 
        int start = 0;
        // mid가 최솟값이어야 함.
        for(int i=0; i<rocks.length; i++){
            if(rocks[i] - start < mid){
                count ++;
            }
            else{
                start = rocks[i];
            }
        }
        
        if(distance - start < mid) count++;
        
        return count;
    }
}