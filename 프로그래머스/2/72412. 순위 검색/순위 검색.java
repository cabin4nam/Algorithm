import java.util.*;
class Solution {
    private static class Info{
        String[] info;
        int score;
        public Info(String[] info, int score){
            this.info = info;
            this.score = score;
        }
    }
    private Map<String, List<Integer>> infoMap = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 모든 info의 가능한 조합을 infoMap에 저장
        for(String inf : info){
            addInfo(inf);
        }
        
        // infoMap 내 점수 리스트를 오름차순 정렬 (이진 탐색을 위함)
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        
        // query를 순회하며 각 조건에 맞는 지원자 수를 계산
        for (int i = 0; i < query.length; i++) {
            String[] queryParts = query[i].replaceAll(" and ", "").split(" ");
            String key = queryParts[0];
            int targetScore = Integer.parseInt(queryParts[1]);
            
            // 조건에 맞는 점수 리스트를 이진 탐색으로 확인
            answer[i] = countQualified(key, targetScore);
        }
        
        return answer;
    }
    
    // 모든 가능한 조합을 생성하고 infoMap에 저장하는 메서드
    private void addInfo(String inf) {
        String[] parts = inf.split(" ");
        int score = Integer.parseInt(parts[4]);
        
        // 각 부분의 조합을 만들기 위해 배열에 저장
        String[] infos = {parts[0], parts[1], parts[2], parts[3]};
        
        // 가능한 모든 조합 생성
        makeCombinations(infos, "", 0, score);
    }
    
    // 조합을 생성하여 infoMap에 삽입하는 메서드
    private void makeCombinations(String[] infos, String currentKey, int depth, int score) {
        if (depth == 4) { // 4개의 정보 조합 완료 시
            // 키가 없으면 새로운 리스트 생성 후 추가
            if (!infoMap.containsKey(currentKey)) {
                infoMap.put(currentKey, new ArrayList<>());
            }
            infoMap.get(currentKey).add(score);
            return;
        }
        
        // 현재 dpeth의 항목과 일치하는 경우 + 다음 depth로 이동
        makeCombinations(infos, currentKey + infos[depth], depth + 1, score);
        
        // '-' 인 경우 무조건 일치 + 다음 depth로 이동
        makeCombinations(infos, currentKey + "-", depth + 1, score);
    }
    
    // 쿼리 조건에 맞는 지원자 수를 계산하는 메서드
    private int countQualified(String key, int targetScore) {
        if (!infoMap.containsKey(key)) return 0;
        
        List<Integer> scores = infoMap.get(key);
        
        // 이진 탐색으로 targetScore 이상인 지원자 수를 계산
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // 조건을 만족하는 점수 개수 반환
        return scores.size() - left;
    }
}