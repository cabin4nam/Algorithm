import java.util.*;
class Solution {
    private static ArrayList<String> list;
    private static int n;
    private static boolean[] visited;
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strs[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(strs, (n1, n2) -> (n2+n1).compareTo(n1+n2));
        
        if(strs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);
        
        answer = sb.toString();
        
        return answer;
    }
    
}