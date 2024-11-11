import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        while(n > 0){
            long n2 = n%10;
            answer.add((int)n2);
            n /= 10;
        }
        return answer;
    }
}