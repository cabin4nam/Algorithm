import java.util.*;
class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        
        // 주어진 정수들의 수가 단 한 개일 때
        if(numbers.length <= 1){
            // target과 같은 값이면, 단 하나의 경우의 수 가능
            if(numbers[0] == target) return 1;
            
            // target과 다른 값이면, target을 만들 수 있는 경우의 수 없음
            else return 0;
        }     
        
        // 맨 첫 숫자가 양수일 때 dfs
        dfs(numbers[0], 1, numbers, target);
        // 맨 첫 숫자가 음수일 때 dfs
        dfs(numbers[0] * (-1) , 1, numbers, target);
        
        return cnt;
    }
    
    public void dfs(int value, int index, int[] numbers, int target){
        // 모든 수를 사용하여 탐색하였음
        if(index == numbers.length){
            // 지금까지 수행한 경우의 수로 인한 결과가 target이면 조합 성공
            if(value == target) cnt++;
            return;
        }
        
        // 현재까지의 값에 다음 값을 더하여 진행
        dfs(value + numbers[index], index+1, numbers, target);
        // 현재까지의 값에 다음 값을 빼서 진행
        dfs(value - numbers[index], index+1, numbers, target);
       
        
    }
}