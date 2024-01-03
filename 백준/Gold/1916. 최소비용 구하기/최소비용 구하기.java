import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int MAX = Integer.MAX_VALUE;
    static class Node{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        ArrayList<Node>[] cityGraph = new ArrayList[cityNum+1];
        for(int i=0; i<cityNum+1; i++) cityGraph[i] = new ArrayList<>();

        for(int i =0; i<busNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(cityGraph[startNode] == null) cityGraph[startNode] = new ArrayList<>();

            cityGraph[startNode].add(new Node(endNode, cost));
        }

        int[] minCost = new int[cityNum+1];
        Arrays.fill(minCost, MAX);

        boolean[] visited = new boolean[cityNum+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        minCost[start] = 0;

        for(int i=1; i<cityNum+1; i++){
            // 모든 노드 중, 해당 노드를 방문하지 않았으면서 가장 가까운 노드를 찾는다.
            int nodeValue = MAX; // 최소 거리값
            int nodeIndex = 0; // 최소 거리값을 가진 노드 인덱스
            for(int j=1; j<cityNum+1; j++){
                if(!visited[j] && minCost[j] < nodeValue){
                    nodeValue = minCost[j];
                    nodeIndex = j;
                }
            }

            // 가장 가까운 노드로 선택된 노드를 방문처리 한다.
            visited[nodeIndex] = true;

            // 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
            for(int j=0; j<cityGraph[nodeIndex].size(); j++){
                Node adjNode = cityGraph[nodeIndex].get(j);

                // 전까지 구했던 거리 비용 보다, 현재 노드(nodeIndex)를 거쳐서 가는 게 더 비용이 적을 때 -> 갱신
                if(minCost[adjNode.node] > minCost[nodeIndex] + adjNode.cost){
                    minCost[adjNode.node] = minCost[nodeIndex] + adjNode.cost;
                }
            }
        }

        System.out.println(minCost[end]);

    }
}