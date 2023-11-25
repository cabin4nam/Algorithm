import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1; // 좌우 조작 1번 경우
        
        for(int i=0;i<name.length();i++) {
            // A에서부터 올라가는 게 빠를 지, Z에서부터 내려오는 게 빠를지
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 다음 인덱스 설정
            index = i+1;
            // 만약 다음 인덱스가 A이면, A가 끝나는 지점을 찾아서 index를 이동시키기
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            move = Math.min(move, i*2+name.length()-index); // 좌우 조작 2번 경우
            move = Math.min(move, (name.length()-index)*2 + i); // 좌우 조작 3번 경우
        }
        return answer + move;
    }
}