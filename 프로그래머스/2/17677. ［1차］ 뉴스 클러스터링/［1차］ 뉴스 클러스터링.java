
// 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 1. 두 문자열을 다중집합의 원소로 만들기
        List<String> u1 = new ArrayList<>();
        List<String> u2 = new ArrayList<>();
        
        makeUnion(u1, str1);
        makeUnion(u2, str2);
        
        // 2. 교집합, 합집합 구하기
        int cross = 0; // 교집합 요소 개수
        int sum = 0; // 합집합 요소 개수
        for(String str : u1){
            // u2도 가지고 있는지 확인
            if(u2.contains(str)){
                cross ++;
                u2.remove(str);
            }
            sum ++;
            
        }
        
        // u1에는 없으나, u2에만 있는 것을 합집합에 더해주기
        sum += u2.size();
        
        // 4. 자카드 유사도 구하기
        if(sum == 0) return 65536;
        answer = Math.round(cross*65536/sum);
        
        return answer;
    }
    
    public void makeUnion(List<String> u, String str){
        for(int i=0; i<str.length()-1; i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            
            // 두 문자 모두 알파벳일때만, 소문자로 변환하여 집합에 저장
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)){
                String s = String.valueOf(c1).toLowerCase() + String.valueOf(c2).toLowerCase();
                
                u.add(s);
            }
        }
    }
}