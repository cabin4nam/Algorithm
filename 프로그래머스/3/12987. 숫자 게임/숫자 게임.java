import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bIndex = B.length-1; // B팀의 인덱스
        
        for(int a=A.length-1; a>=0; a--){
            if(B[bIndex] > A[a]){
                answer ++;
                bIndex --;
            }
        }
        
        return answer;
    }
}

