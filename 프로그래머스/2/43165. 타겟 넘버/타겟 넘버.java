class Solution {
    private static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        makeNum(numbers, target, 0, 0);
        
        return answer;
    }
    
    private static void makeNum(int[] numbers, int target, int result, int depth){
        if(depth == numbers.length){
            if(target == result) answer ++;
            return;
        }
        
        makeNum(numbers, target, result+(numbers[depth]*(-1)), depth+1);
        makeNum(numbers, target, result+(numbers[depth]), depth+1);
        
    }
}