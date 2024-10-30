import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 50 50 70 80
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while (left <= right) {
            answer++; // 보트 사용
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람 태움
            }
            right--; // 무거운 사람 태움
        }
        
        return answer;
    
    }
}