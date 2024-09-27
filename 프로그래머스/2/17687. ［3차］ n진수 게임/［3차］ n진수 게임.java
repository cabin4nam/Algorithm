import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder answerSb = new StringBuilder();
        
        int num = 0;
        StringBuilder convert = new StringBuilder(); //필요한 만큼 n진수로 변환

        // nun을 n진수로 변경
        // 필요한 숫자가 충분히 채워질 때까지 반복
        while (convert.length() < t * m) {
            // changeToN(nums, num++, n);  // 숫자를 n진법으로 변환하여 nums 리스트에 추가
            convert.append(Integer.toString(num++, n));
        }

        // 튜브가 말해야 하는 숫자를 순서대로 answer에 추가
        for(int i=p-1; answerSb.length() < t; i+=m){
            answerSb.append(String.valueOf(convert.charAt(i)));
        }
        
        answer =  answerSb.toString().toUpperCase();
        return answer;
    }
    
}