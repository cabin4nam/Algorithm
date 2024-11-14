import java.util.*;
class Solution {
    private static boolean[] visited;
    private static int answer;
    private static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        
        set = new HashSet<>();
        visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, "");

        answer = set.size();
        return answer;
    }
    
    private static void dfs(String[] user_id, String[] banned_id, int index, String result){
        if(index == banned_id.length){ // 끝까지 탐색 성공했으면
            String[] ids = result.split(" ");
            Arrays.sort(ids);
            
            StringBuilder str=new StringBuilder();
			for(String s:ids) str.append(s);//정렬된 id들을 하나의 문자열로 추가
			set.add(str.toString());
            
            return;
        }
        
        String target = banned_id[index]; // 불량사용자 아이디 패턴에 맞는 사용자 찾기
        
        for(int i=0; i<user_id.length; i++){
            // target에 맞는 사용자 아이디라면
            if(isMatched(target, user_id[i]) && !visited[i]){
                // visited = true 처리한 후, 깊이 우선 탐색 
                visited[i] = true;
                dfs(user_id, banned_id, index+1, result+" " +user_id[i]);
                visited[i] = false;
            } 
        }
    }
    
    private static boolean isMatched(String target, String id){
        if(target.length() != id.length()) return false;
        
        for(int i=0; i<target.length(); i++){
            if(target.charAt(i)!='*' && target.charAt(i) != id.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}