class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int next = n+1;
        int bitCnt = Integer.bitCount(n);
        while(true){
            if(Integer.bitCount(next)==bitCnt){
                answer = next;
                break;
            }
            
            next ++;
        }
        
        return answer;
    }
}