import java.util.*;
class Solution {
    static Set<Integer> madeNumbers;
    static boolean[] visited;
    static int answer = 0;
    public int solution(String numbers) {
        
        madeNumbers = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            visited[i] = true;
            dfs(numbers, i, "");
            visited[i] = false;
        }
        
        for(int n : madeNumbers){
            if(isPrime(n)) answer ++;
        }
        
        return answer;
    }
    
    private void dfs(String numbers, int index, String number){
        String addedNum = number + numbers.substring(index, index+1);
        
        madeNumbers.add(Integer.parseInt(addedNum));
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, i, addedNum);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}