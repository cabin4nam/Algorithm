import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> students = new ArrayList<>(); // 학생들 정보 저장할 인접 리스트 
        for(int i=0; i<=N; i++){ // 초기화
            ArrayList<Integer> node = new ArrayList<>();
            students.add(node);
        }
        
        int[] indegree = new int[N+1]; // 학생들 노드의 진입차수 배열
        for(int i=1; i<=N; i++) indegree[i] = 0; // 초기화

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            // 학생들의 선후 관계 정보 -> 인접 리스트에 저장
            students.get(s1).add(s2);

            // 진입 차수 배열 업데이트
            indegree[s2] ++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 학생(노드)를 큐에 먼저 저장 (초기 세팅)
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            // 큐에서 학생 하나 꺼내서 출력
            int student = queue.poll();
            System.out.print(student + " ");

            // 꺼낸 학생 다음에 올 학생들의 진입차수 하나씩 줄여주기. -> 진입차수가 0이 되는 학생이 있으면 역시 queue에 저장
            for(int i=0; i<students.get(student).size(); i++){
                int node = students.get(student).get(i);
                indegree[node] --;
                
                if(indegree[node] == 0) queue.offer(node);
            }
        }
    }

}