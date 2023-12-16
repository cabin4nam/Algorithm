import java.util.*;
class Solution {
    static boolean[] visited;
    static boolean success = false;
    static String[] answerArr;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        // 여행지를 알파벳 순으로 정렬
        Arrays.sort(tickets, (t1, t2) -> {
            if(t1[0].equals(t2[0])){
                return t1[1].compareTo(t2[1]);
            }
            else {
                return t1[0].compareTo(t2[0]);
            }
        });
        
        for(int i=0; i<tickets.length; i++){
            System.out.println(success);
            if(success) break;
            
            if(tickets[i][0].equals("ICN")){
                // answerArr = new ArrayList<>();
                visited = new boolean[tickets.length + 1];
                // answerArr2 = new ArrayList<>();
                dfs(i, tickets, "ICN ");
            }
        }
        return answerArr;
    }
    
    public void dfs(int start, String[][] tickets, String path){   
        if(success) return;
        if(path.split(" ").length==tickets.length){
            path += tickets[start][1];
            answerArr =  path.split(" ");
            success = true;
            return;  
        } 
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[start][1].equals(tickets[i][0])){
                if(visited[i]) continue;
                
                visited[start] = true;
                dfs(i, tickets, path + tickets[start][1] + " ");
                visited[start] = false;
            }
        }
    }
}