import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String c = clothes[i][0];
            String category = clothes[i][1];
            
            if(map.get(category) == null) map.put(category, new ArrayList<>());
            map.get(category).add(c);
        }
        
        // 각 의상 별로 종류의 개수 + 안쓰는 것의 개수 합 - 1(아무것도 안입을 수는 없음)
        for(String key : map.keySet()){
            answer*= map.get(key).size()+1;
        }
        
        return answer-1;
    }
}