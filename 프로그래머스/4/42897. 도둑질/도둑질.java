class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        // 첫 번째 집을 무조건 털고, 마지막 집을 털지 않는 경우의 dp
        int[] dp_first = new int[money.length];
         dp_first[0] = dp_first[1] = money[0];
        
        // 첫 번째 집을 무조건 털지 않고, 마지막 집을 무조건 터는 경우의 dp
        int[] dp_last = new int[money.length];
       
        dp_last[0] = 0;
        dp_last[1] = money[1];
        
        for(int i=2; i< money.length; i++){
            // 현재 집의 이웃한 집을 털고, 현재 집을 털지 않을 때와
            // 현재 집의 이웃한 집을 털지 않은 상태에서, 현재 집을 털 때의 최댓값 구해서 answer 갱신
            
            dp_last[i] = Math.max(dp_last[i-1], dp_last[i-2] + money[i]);
            answer = Math.max(dp_last[i], answer);
            
            if(i==money.length-1) break;
            
            dp_first[i] = Math.max(dp_first[i-1], dp_first[i-2]+money[i]);
            answer = Math.max(dp_first[i], answer);
        }
    
        return answer;
    }
}