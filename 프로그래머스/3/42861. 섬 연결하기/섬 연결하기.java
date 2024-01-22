import java.util.*;
class Solution {
    static int edge_cnt;
    static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        edge_cnt = 0; // 연결한 엣지 수 (n-1개가 될때까지 반복문을 순환)
        parents = new int[n]; // 부모 노드를 저장
        for(int i = 0; i<n; i++){ // 초기 설정은 본인 노드를 부모로 지정
            parents[i] = i;
        }
        
        // costs를 가중치 기준으로 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] c1, int[] c2){
                return c1[2]>=c2[2] ? 1 : -1;
            }
        });
            
        for(int i=0; i<costs.length; i++){
            if(edge_cnt == n-1) break;
            
            int parent1 = find(costs[i][0]);
            int parent2 = find(costs[i][1]);
            
            if(parent1 != parent2){
                union(costs[i][0], costs[i][1]);
                edge_cnt++;
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    private int find(int node){
        if(parents[node] == node) return node;
        
        else return parents[node] = find(parents[node]);
    }
    
    private void union(int node1, int node2){
        parents[find(node2)] = parents[find(node1)];
    }
}