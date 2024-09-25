class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");
        
        int idx = 0;
        boolean isFirst = true;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c==' '){
                isFirst = true;
                sb.append(" ");
                continue;  
            } 
            
            if(isFirst){ //대문자로 변경
                if(Character.isAlphabetic(c)) sb.append(String.valueOf(c).toUpperCase());
                else sb.append(c);
                
                isFirst = false;
            }
            else { // 소문자로 변경
                sb.append(String.valueOf(c).toLowerCase());
            }
        }
                
//         for(int i=0; i<arr.length; i++){
//             String str = arr[i];
//             // 첫 문자는 대문자로 변경
//             if(Character.isAlphabetic(str.charAt(0))){
//                 sb.append(str.substring(0,1).toUpperCase());
//             }
//             else sb.append(str.substring(0,1));
            
//             // 나머지 문자는 소문자로 변경
//             sb.append(str.substring(1, str.length()).toLowerCase());
            
//             if(i < arr.length-1)
//                 sb.append(" ");
//         }
        
        answer = sb.toString();
        
        return answer;
    }
}