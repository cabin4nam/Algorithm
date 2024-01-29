import java.util.*;
import java.io.*;

class Main {
    static int subin;
    static int bro;
    static int count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        // *2 한 노드를 앞에 배치하고, +1, -1 이동한 노드는 순서대로 배치한다.
        // 시간 오름차순으로 설정
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        pq.offer(new int[]{subin, 0}); // 현재 위치와, 현재 시간 저장
        boolean[] visited = new boolean[100_001];

        int count = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll(); // 방문하는 점
            int nPosition = now[0]; // 방문한 점의 위치
            count = now[1]; // 방문한 점의 시간
            
            // 동생이 있는 점에 방문하면 -> 반복문 탈출
            if(nPosition == bro) break;

            visited[nPosition] = true;
            
            // 2배한 위치 (순간이동) -> count 변화 없음
            if(nPosition *2 <= 100_000 && !visited[nPosition*2])
                pq.offer(new int[] {nPosition*2, count});
            // +1 이동한 위치 (걷기) -> count+1
            if(nPosition < bro && nPosition+1 <= 100_000 && !visited[nPosition+1])
                pq.offer(new int[]{nPosition+1, count+1});
            // -1 이동한 위치 (걷기) -> count-1
            if(nPosition-1 >= 0 && !visited[nPosition-1])
                pq.offer(new int[]{nPosition-1, count+1});
        }

        System.out.println(count);
        
    }
}

