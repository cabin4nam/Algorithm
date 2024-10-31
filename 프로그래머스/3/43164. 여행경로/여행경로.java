import java.util.*;
class Solution {
    private static ArrayList<String> routes;
    private static boolean[] visited;
    public String[] solution(String[][] tickets) {
        
        routes = new ArrayList<>();
        visited=  new boolean[tickets.length+1];
        dfs(0, "ICN","ICN", tickets);
        
        Collections.sort(routes);
        
        return routes.get(0).split(",");
    }
    
    private static void dfs(int depth, String now, String route, String[][] tickets){
        if(depth == tickets.length){
            routes.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth +1, tickets[i][1], route+","+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
    
}