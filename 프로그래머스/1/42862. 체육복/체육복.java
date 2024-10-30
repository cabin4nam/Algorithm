import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 배열 인덱스 : 학생 번호, 배열 값 : 학생이 가지고 있는 체육벌 개수
        int[] count = new int[n+1];
        Arrays.fill(count, 1);
        for(int i : lost) count[i]--;
        for(int i : reserve) count[i]++;
        
        for (int i = 1; i <= n; i++) {
            // 현재 학생이 체육복을 잃어버렸고, 앞 또는 뒤 학생에게 빌릴 수 있는지 확인
            if (count[i] == 0) {
                if (i > 1 && count[i - 1] == 2) {
                    count[i]++;
                    count[i - 1]--;
                } else if (i < n && count[i + 1] == 2) {
                    count[i]++;
                    count[i + 1]--;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(count[i] >= 1) answer ++;
        }
        
        
        return answer;
    }
}