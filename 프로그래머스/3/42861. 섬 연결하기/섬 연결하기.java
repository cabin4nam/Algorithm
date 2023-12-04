import java.util.*;
class Solution {
    static int[] parent; // 대표 노드(부모 노드)를 저장할 배열
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 대표 노드 배열 초기화
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        // 크루스칼 알고리즘을 사용하기 위해 가중치 기준 오름차순 정렬 (2번)
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);
        
        // 가중치가 작은 것부터 (처음부터) 연결 시도
        for(int i=0; i<costs.length; i++){
            // find 연산으로 찾은 대표 노드가 서로 다를때만 연결
            if(find(costs[i][0]) != find(costs[i][1])){
                // union연산으로 연결
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    private int find(int node){
        if(parent[node] == node)
            return node;
        
        return parent[node] = find(parent[node]);
    }
    
    private void union(int node1, int node2){
        int parent_node1 = find(node1);
        int parent_node2 = find(node2);
        
        parent[parent_node1] = parent_node2;
    }
}