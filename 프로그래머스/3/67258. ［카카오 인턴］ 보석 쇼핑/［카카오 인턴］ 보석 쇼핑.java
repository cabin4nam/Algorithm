import java.util.*;

class Solution {
    private static int[] answer;
    private static int maxCount = 0;
    public int[] solution(String[] gems) {
        answer = new int[2];
        
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        
        // 최단 구간
        int length = Integer.MAX_VALUE;
        int start = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int end = 0; end<gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
            
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
            
            if(map.size() == kind && length > (end-start)){
                length = end-start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        
        return answer;
    }
    
}