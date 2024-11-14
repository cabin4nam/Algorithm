import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // 6 5 3 1 0
        Arrays.sort(citations);
        
        for(int h=citations.length; h>=1; h--){
            if(isValid(citations, h)) return h;
        }
        
        return 0;
    }
    private static boolean isValid(int[] citations, int h){
        int index = citations.length-h;
        return citations[index] >= h;
    }
}