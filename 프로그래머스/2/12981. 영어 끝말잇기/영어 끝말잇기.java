import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char end = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++){
            // 직전의 단어의 끝 알파벳 != 이번 단어의 첫 알파벳 이면 탈락
            // 이전에 나왔던 단어라면, 탈락
            if(words[i].charAt(0)!=end || set.contains(words[i])){
                // 탈락자 인덱스 계산
                int person = i%n+1;
                int turn = i/n+1;
                answer[0] = person;
                answer[1] = turn;
                break;
            }
            
            set.add(words[i]);
            end = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}