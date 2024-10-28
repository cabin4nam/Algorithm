import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] arr1 = new int[answers.length];
        int[] arr2 = new int[answers.length];
        int[] arr3 = new int[answers.length];
        
        // 수포자 답안 배열 완성
        for(int i=0; i<answers.length; i++){
            // 1번 수포자
            arr1[i] = (i+5)%5+1;
            
            // 2번 수포자
            // 1 3 5 7, 9 11 13 15 17
            if(i%2 == 0) arr2[i] = 2;
            else {
                if(i%8 == 1) arr2[i] = 1;
                else if(i%8 == 3) arr2[i] = 3;
                else if(i%8 == 5) arr2[i] = 4;
                else if(i%8 == 7) arr2[i] = 5;
            }
            
            // 3번 수포자
            // 0 1 / 2 3 / 4 5 / 6 7 / 8 9 // 10 11 / 12 13 /
            // 33 11 22 44 55/ 33
            if(i%10 <= 1) arr3[i] = 3;
            else if(i%10 <= 3) arr3[i] = 1;
            else if(i%10 <= 5) arr3[i] = 2;
            else if(i%10 <= 7) arr3[i] = 4;
            else if(i%10 <= 9) arr3[i] = 5;
        }
        
        int cnt1=0, cnt2 =0, cnt3 =0;
        for(int i=0; i<answers.length; i++){
            if(arr1[i] == answers[i]) cnt1++;
            if(arr2[i] == answers[i]) cnt2++;
            if(arr3[i] == answers[i]) cnt3++;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        if(cnt1 == max) answer.add(1);
        if(cnt2 == max) answer.add(2);
        if(cnt3 == max) answer.add(3);
        
        return answer;
    }
}