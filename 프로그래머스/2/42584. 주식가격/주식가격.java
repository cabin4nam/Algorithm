import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i=1; i<prices.length; i++){
            while(!stack.empty() && prices[i] < prices[stack.peek()]){
                int j = stack.pop();
                answer[j] = i-j;
            }  
            stack.push(i);
        }
        
        while(!stack.empty()){
            int i = stack.pop();
            
            answer[i] = prices.length-i-1;
        }
        
        return answer;
    }
}