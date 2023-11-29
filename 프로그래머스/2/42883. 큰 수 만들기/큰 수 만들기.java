class Solution {
    int[] numberArr;
    public String solution(String number, int k) {
        String answer = "";
        
        int remain_cnt = number.length() - k;
        numberArr = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            numberArr[i] = Integer.parseInt(number.substring(i, i+1));
        }
        
        int start = 0;
        int end = number.length() - remain_cnt;
        while(true){
            if(remain_cnt <= 0) break;
            
            int max_index = findMax(start, end);
            answer += numberArr[max_index];
            
            remain_cnt --;
            start = max_index+1;
            end = number.length() - remain_cnt;
            
        }
        
        return answer;
    }
    
    public int findMax(int start, int end){
        int max_index = start;
        for(int i=start; i<=end; i++){
            if(numberArr[max_index] < numberArr[i]) max_index = i;
        }
        
        return max_index;
    }
    
}