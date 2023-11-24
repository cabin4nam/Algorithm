import java.util.ArrayList;
import java.util.List;
class Solution {
    static String[] index = {"A", "E", "I", "O", "U"};
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        // dfs로 사전에 들어있는 모든 문자열 경우의 수 list에 저장 
        dfs("", 0, word);
        
        // list에서 word가 몇 번째에 위치하는 지 찾기
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
   
    static void dfs(String str, int depth, String word) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < index.length; i++) {
            dfs(str + index[i], depth + 1, word);
        }
    }
}