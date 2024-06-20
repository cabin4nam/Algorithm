import java.util.*;

class Solution {
    // 만들 수 있는 메뉴 구성과 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for(int i : course){
            courseMap.put(i, new HashMap<>());
        }
        
        // 코스를 배열로 만들고, 오름차순 정렬해서, 가능한 모든 메뉴 구성 구하기
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray); // 각 String 내의 character를 정렬, String 간의 정렬은 일어나지 않음
            combinations(0, orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        // 모든 코스 후보에 대해서
        for(HashMap<String, Integer> count : courseMap.values()){
            count.values().stream()
                .max(Comparator.comparingInt(o -> o)) // 가장 빈도 수가 높은 코스를 찾음
                .ifPresent(cnt -> count.entrySet().stream()
                           // 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만
                           .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                           //코스 메뉴를 answer 리스트에 추가
                           .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
        
    }
    
    // 만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, String result){
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for(int i=idx; i<order.length; i++){
            combinations(i+1, order, result+order[i]);
        }
    }
}