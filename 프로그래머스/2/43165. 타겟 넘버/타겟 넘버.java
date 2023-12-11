import java.util.*;
class Solution {
    static boolean[] visited;
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        visited = new boolean[numbers.length];
        if(numbers.length <= 1){
            if(numbers[0] == target) return 1;
            else return 0;
        }     
        
        
        dfs(numbers[0], 1, numbers, target);
        dfs(numbers[0] * (-1) , 1, numbers, target);
        
        return cnt;
    }
    
    public void dfs(int value, int index, int[] numbers, int target){
        if(index == numbers.length){
            if(value == target) cnt++;
            return;
        }
        
        dfs(value + numbers[index], index+1, numbers, target);
        dfs(value - numbers[index], index+1, numbers, target);
       
        
    }
}