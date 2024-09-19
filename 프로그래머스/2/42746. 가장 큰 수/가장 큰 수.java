// 완전탐색 -> 시간 초과
// class Solution {
//     private static boolean[] visited;
//     private static String answer;
//     public String solution(int[] numbers) {
//         answer = "";
        
//         visited = new boolean[numbers.length];
//         dfs(numbers, 0, "");
        
//         return answer;
//     }
    
//     public void dfs(int[] numbers, int depth, String result){
//         if(depth == numbers.length){
//             if(answer.equals("")) answer = result; 
//             else if(Integer.parseInt(answer) < Integer.parseInt(result)){
//                 answer = result;
//             }
//             return;
//         }
        
//         for(int i=0; i<numbers.length; i++){
//             if(!visited[i]){
//                 visited[i] = true;
//                 dfs(numbers, depth +1, result+numbers[i]);
//                 visited[i] = false;
//             }
//         }
//     }
// }

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> numList = new ArrayList<>(numbers.length);
        for(int n : numbers){
            numList.add(Integer.toString(n));
        }
        
        Collections.sort(numList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(String n : numList){
            answer += n;
        }
        if(numList.get(0).equals("0")) answer = "0";
        return answer;
    }
}