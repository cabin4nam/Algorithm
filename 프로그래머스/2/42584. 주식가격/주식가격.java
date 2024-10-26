import java.util.Stack;
class Solution {
    private static class Stock{
        int idx;
        int price;
        public Stock(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> stack = new Stack<>();
        int now = 0;
        
        while(now < prices.length){
            // 다음 주식(prices[idx]) 가격이 더 크거나 같으면 push
            if(stack.isEmpty() || prices[now] >= stack.peek().price){
                stack.push(new Stock(now, prices[now]));
                now++;
            } 
            
            // 다음 주식 가격이 더 작으면 pop, answer갱신
            else{
                Stock s = stack.pop();
                answer[s.idx] = now - s.idx;
            }
        }
        
        while(!stack.isEmpty()){
            Stock s = stack.pop();
            
            answer[s.idx] = prices.length-s.idx-1;
        }
        
        return answer;
    }
}