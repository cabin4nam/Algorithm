class Solution {
    public int[] solution(int n, int s) {
        if(s/n == 0){
            int[] answer = {-1};
            return answer;
        }
            
        int[] answer = new int[n];
        
        
        for(int i=0; i<n; i++){
            answer[i] = s/n;
        }
        
        int gap = s - (s/n*n);
        
        int idx = n-1;
        while(gap > 0){
            answer[(idx+n)%n] ++;
            gap --;
            idx --;
        }
        
        
        
        return answer;
    }
}