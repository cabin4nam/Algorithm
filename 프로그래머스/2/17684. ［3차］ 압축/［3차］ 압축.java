

import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> index = new HashMap<>();
        
        // 사전 초기화 (A=1, B=2, ..., Z=26)
        for (int i = 0; i < 26; i++) {
            index.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        int dictSize = 27; // 다음에 사전에 추가할 색인 번호
        int start = 0; // 문자열 탐색 시작 위치
        
        while (start < msg.length()) {
            String w = ""; // 현재 사전에 있는 가장 긴 문자열
            
            // 사전에 있는 가장 긴 문자열 찾기
            for (int len = 1; start + len <= msg.length(); len++) {
                String candidate = msg.substring(start, start + len);
                if (index.containsKey(candidate)) {
                    w = candidate; // 사전에 있으면 w에 저장
                } else {
                    break; // 사전에 없으면 종료
                }
            }
            
            // 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾았으므로 해당 색인 번호를 출력
            answer.add(index.get(w));
            
            // 다음 글자가 남아있다면, 사전에 w+c 추가
            if (start + w.length() < msg.length()) {
                String c = msg.substring(start + w.length(), start + w.length() + 1);
                index.put(w + c, dictSize++);
            }
            
            // 다음 탐색 위치를 현재 w의 길이만큼 이동
            start += w.length();
        }
        
        return answer;
    }
}
