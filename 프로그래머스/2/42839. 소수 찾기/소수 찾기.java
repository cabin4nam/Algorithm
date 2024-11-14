import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    private static char[] arr;
    private static boolean[] visited;
    private static HashSet<Integer> set;
    private static int answer;
    public int solution(String numbers) {
        answer = 0;
        
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        arr = numbers.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            visited[i] = true;
            findNum(String.valueOf(arr[i]), 0);
            visited[i] = false;
        }
        
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private static void findNum(String result, int depth){
        if(depth >= arr.length) return;
        
        set.add(Integer.parseInt(result));
        
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                findNum(result+String.valueOf(arr[i]), depth+1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int n){
        if(n<=1) return false;
        
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
    
}