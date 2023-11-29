import java.util.*;
class Solution {
    static int cnt=0;
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer++;
        }

        return answer;
    }
    
    public void func(int start, int end, int weightSum, int limit, int[] people){
        if(start >= people.length || end >= people.length){
            cnt++;
            return;
        }
        
        if(weightSum + people[end] <= limit){
            func(start, end+1, weightSum+people[end], limit, people);
        } 
        else {
            cnt++;
            func(end, end+1, people[end], limit, people);
        }
        
    }
}