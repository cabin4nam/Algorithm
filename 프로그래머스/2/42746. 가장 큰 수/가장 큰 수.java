import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
               int original = Integer.parseInt(s1+s2);
                int reverse = Integer.parseInt(s2+s1);
                return reverse - original;
            })
            .toArray(String[]::new);
        
         if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);  
        }
        answer = sb.toString();
        
        return answer;
    }
}