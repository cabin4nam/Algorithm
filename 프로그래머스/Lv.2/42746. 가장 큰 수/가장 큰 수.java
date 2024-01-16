import java.util.*;
class Solution {    
    public String solution(int[] numbers) {
        String answer = "";
        boolean except = true; //변수들이 0 밖에 없을 때 "00000~"을 반환하는 예외 케이스를 위해
        
        String[] num = new String[numbers.length];
        
        for(int i=0; i< num.length; i++){
            num[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) except = false;
        }
            
        
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2){
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        for(int i=0; i<num.length; i++)
            answer += num[i];
    
        if(except) answer = "0";
        return answer;
    }
}