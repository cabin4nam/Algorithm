import java.util.*;

class Solution {
    private static ArrayList<Integer>[] matched;
    private static boolean[] visited;
    private static int size;
    private static int answer = 0;
    private static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        size = banned_id.length;
        matched = new ArrayList[size];
        
        // 각 banned_id에 매칭될 수 있는 user_id를 저장해주기
        for(int i=0; i<size; i++){
            matched[i] = findMatched(user_id, banned_id[i]);
        }
        
        // 중복을 허용하지 않는 자료구조에 user_id조합을 저장해, 개수 세기
        set = new HashSet<>();
        dfs(user_id, 0, "");
        
        answer = set.size();
        
        return answer;
    }
    
    public void dfs(String[] user_id, int idx, String res){
        // 모든 banned_id를 탐색 완료하면
        if(idx >= size){
            String[] str = res.split(" ");
            Arrays.sort(str);            
            StringBuilder sb = new StringBuilder();
            for(String s : str) sb.append(s);
            set.add(sb.toString());
            return;
        }
        
        // 현재 idx와 매칭될 수 있는 문자열 중, 아직 방문하지 않은 것에 대해 추가해주기
        for(int i=0; i<matched[idx].size(); i++){
            int selected = matched[idx].get(i);
            
            if(!visited[selected]){
                visited[selected] = true;
                dfs(user_id, idx+1, res+ " " + user_id[selected]);
                visited[selected] = false;
            }
        }
    }
    
    // banned사용자 문자열과 맞는 user id를 저장해주기
    public ArrayList<Integer> findMatched(String[] user_id, String target){
        ArrayList<Integer> matched = new ArrayList<>();
        for(int i = 0; i<user_id.length; i++){
            boolean isMatched = true;
            if(user_id[i].length() != target.length() || visited[i]){
                isMatched = false;
            }
            
            else {
                for(int j=0; j<user_id[i].length(); j++){
                    if(target.charAt(j)!='*' && user_id[i].charAt(j) != target.charAt(j)){
                        isMatched = false;
                        break;

                    }
                }
            }
            
            if(isMatched) matched.add(i);
        }
        
        return matched;
    }
}