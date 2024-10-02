import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int count = nums.length/2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        if(map.size() >= count) answer = count;
        else answer = map.size();
        
        return answer;
    }
}