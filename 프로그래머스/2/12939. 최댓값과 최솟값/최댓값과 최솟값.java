class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] nums = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            int n = Integer.parseInt(nums[i]);
            
            if(min > n) min = n;
            if(max < n) max = n;
        }

        answer += min + " " + max;
        return answer;
    }
}