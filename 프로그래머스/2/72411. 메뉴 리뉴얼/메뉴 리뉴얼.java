import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int c : course){
            HashMap<String, Integer> map = new HashMap<>();
            
            for(String o : orders){
                boolean[] visited = new boolean[o.length()];
                char[] charArr = o.toCharArray();
                Arrays.sort(charArr);
                for(int i=0; i<charArr.length; i++){
                    visited[i] = true;
                    makeMenu(i, c, String.valueOf(charArr), map, visited, String.valueOf(charArr[i]));
                    visited[i] = false;
                }
            }
            
            // map을 value 기준 내림차순 정렬
            ArrayList<String> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (k1, k2) -> map.get(k2)-map.get(k1));
            
            int max = map.get(keys.get(0));
            if(max < 2) break;
            
            for(String k : keys){
                if(max == map.get(k)) answer.add(k);
                else break;
            }
            
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    private static void makeMenu(int start, int count, String order, HashMap<String, Integer> map, boolean[] visited, String result){
        if(result.length() == count){
            map.put(result, map.getOrDefault(result, 0)+1);
            return;
        }
        
        for(int i=start+1; i<order.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                makeMenu(i, count, order, map, visited, result+order.substring(i,i+1));
                visited[i] = false;
            }
        }
    }
}