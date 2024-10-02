import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 조합을 정확히 어떤 것을 입는지 트래킹해야 하면 ? 완전탐색
        // 조합의 개수를 구할 때 ? 단순 계산
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String key : map.keySet()){
            answer *= map.get(key)+1;
        }
        
        answer -= 1;
        
        return answer;
    }
}