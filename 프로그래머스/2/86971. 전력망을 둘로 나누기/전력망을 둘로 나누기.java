import java.util.*;
class Solution {
    /**
    *   1. 입력받은 wires로 그래프를 인접 리스트로 표현
        2. wires를 for문으로 순회하면서 각 연결을 끊기.
            1. dfs를 진행 → 끊으려는 wires가 나오면 해당 연결이 없는 것 처럼 생략
            2. 하나의 개수가 나오면 나머지 개수도 알 수 있음. 
            3. 차이가 적은 것을 골라 max에 업데이트
        3. max 출력
    **/
    static ArrayList<ArrayList<Integer>> wireList;
    static int depth = 0;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        // 그래프를 담을 인접 리스트 초기화
        wireList = new ArrayList<>();
        for(int i=0; i<=n; i++)
            wireList.add(i, new ArrayList<>());
        
        // 그래프를 인접 리스트에 표현
        for(int i=0; i<wires.length; i++){
            wireList.get(wires[i][0]).add(wires[i][1]);
            wireList.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i=0; i<wires.length; i++){
            boolean[] visited = new boolean[n+1];
            depth = 1;
            visited[1] = true;
            dfs(wires, i, 1, visited); // dfs(wire index, start, visited)
            if(answer == -1) answer = Math.abs(depth- (n-depth));
            else answer = Math.min(answer, Math.abs(depth - (n-depth)));
            
        }
        
        return answer;
    }
    
    public void dfs(int[][] wires, int index, int start, boolean[] visited){
        // wires[index][0] 과 wires[index][1]을 끊은 상태에서 dfs
        for(int w : wireList.get(start)){
            if(visited[w]) continue;
            if((start==wires[index][1] && w==wires[index][0])|| (start==wires[index][0] && w==wires[index][1])) continue;
            
            visited[w] = true;
            depth++;
            dfs(wires, index, w, visited);
        }
    }
}