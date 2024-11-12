class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int zeros = 0;
        while(!s.equals("1")){
            count ++;
            // s의 모든 0 제거
            zeros += countZero(s);
            s = s.replace("0", "");
            
            // s의 길이 c를 2진법으로 표현한 문자열을 s에 저장
            int c = s.length();
            String n = Integer.toString(c, 2);
            s = n;
        }
        
        answer[0] = count;
        answer[1] = zeros;
        return answer;
    }
    
    private static int countZero(String s){
        int count =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0') count ++;
        }
        
        return count;
    }
}