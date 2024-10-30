//https://loosie.tistory.com/480
import java.io.*;
import java.util.*;
public class Main{
    private static class Class{
        int start;
        int end;
        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Class> classList = new ArrayList<>(); // 수업 목록
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classList.add(new Class(start, end));
        }

        // 시작시간(1순위), 종료시간(2순위) 기준 오름차순 정렬
        Collections.sort(classList, new Comparator<Class>(){
            @Override
            public int compare(Class o1, Class o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                }else return o1.start - o2.start;
            }
        });

        // 강의실에 우선순위에 따라 배치하기 위해 우선순위 큐 사용하기 (종료시간 비교)
        // classList를 돌면서, 아직 하지 않은 수업 중, 종료시간이 가장 빠른 것을 먼저 배치하고
        // 그 수업 종료 후에 같은 강의실에 배치할 수 있는 수업들을 배치하여, 그 강의실 사용 가능 시간 갱신
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int endTime = 0;
        for(Class c : classList){
            // 아직 하지 않은 수업 중, 시작시간과 종료시간이 가장 빠른 것
            endTime = c.end;

            if(!pq.isEmpty() && pq.peek() <= c.start){
                pq.poll(); // 같은 강의실에 배치하면 되므로, 그 강의실의 기존 endTime을 새로운 수업의 endTime으로 갱신
            }

            pq.offer(endTime);
        }

        // pq에 남은 것들이 강의실의 크기
        System.out.println(pq.size());

    }
}