import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        int size = array.length;
        ArrayList<Integer> answer = new ArrayList<>();
        
        // commands 하나 당 작업 한번
        for(int c = 0; c<commands.length; c++){
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            
            // 배열 추출
            int[] newArr = Arrays.copyOfRange(array, i-1 ,j);
            
            // 배열 정렬
            Arrays.sort(newArr);
            
            // k번째 값 저장
            answer.add(newArr[k-1]);
        }
        
        return answer;
    }
}