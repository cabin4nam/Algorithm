class Solution {
    public String solution(String s, int n) {
        String answer = s;
        
        for(int t = 0; t<n; t++){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<answer.length(); i++){
                char c = answer.charAt(i);

                if(c==' '){ // 공백
                    sb.append(' ');
                    continue;
                } 
                
                if(!Character.isAlphabetic((char)(c+1))){
                    if(Character.isUpperCase(c)) sb.append('A');
                    else if(Character.isLowerCase(c)) sb.append('a');
                }
                else sb.append((char)(c+1));

            }
            answer = sb.toString();
        }
        
        
        return answer.toString();
    }
}