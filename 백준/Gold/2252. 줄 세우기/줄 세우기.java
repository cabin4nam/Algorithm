import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이 코드가 왜 틀렸는지 모르겠다...

/**
 * 반례 ::
 *
 * 입력
 * 5 4
 * 2 3
 * 1 2
 * 4 2
 * 5 2
 *
 * 정답
 * 1 4 5 2 3
 */
public class Main {
    static ArrayList<Integer>[] students; // 그래프를 표현할 자료구조
    static int[] indegree;// 진입차수를 저장할 자료구조
    static boolean[] visited; // 방문 검사 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        students = new ArrayList[N+1];
        for(int i=0; i< students.length; i++){
            students[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        Arrays.fill(indegree, 0);
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int beforeStudent = Integer.parseInt(st.nextToken());
            int afterStudent = Integer.parseInt(st.nextToken());

            indegree[afterStudent] ++;
            students[beforeStudent].add(afterStudent);
        }

        for(int i=1; i<=N; i++){
//            System.out.println("upper code");
            if(!visited[i]) makeLine(i);
        }
    }

    static private void makeLine(int index){
        // 만약 진입차수가 0이면 바로 출력

        if(indegree[index]==0 && !visited[index]){
            System.out.println(index);
            visited[index] = true;
            for(int s : students[index]){
                if(!visited[s]){
                    indegree[s] --;
                    makeLine(s);
                }
            }
        }
    }
}