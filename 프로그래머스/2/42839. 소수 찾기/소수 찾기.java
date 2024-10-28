import java.util.HashSet;
class Solution {
    private HashSet<Integer> nums;
    private static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        
        nums = new HashSet<>();
        visited = new boolean[numbers.length()];
        for(int i=1; i<=numbers.length(); i++){
            findNums(i, 0, "", numbers);
        }
        
        for(int n : nums){
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    public void findNums(int count, int depth, String result, String numbers){
        if(count == depth){
            nums.add(Integer.parseInt(result));
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                findNums(count, depth+1, result+String.valueOf(numbers.charAt(i)), numbers);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n == 0 || n==1) return false;
        
        for(int i=2; i*i<=n; i++)
            if(n%i == 0) return false;
        
        return true;
    }
}