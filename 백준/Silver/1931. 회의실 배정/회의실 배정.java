import java.io.*;
import java.util.*;
public class Main{
    private static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    private static class Room{
        int count;
        int end;
        public Room(int count , int end){
            this.count = count;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // meetings sorting
        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end==o2.end) return o1.start - o2.start;
                else return o1.end - o2.end;
            }
        });

        int count = 0;
        int lastEnd = 0;

        // 종료 시간을 1순위, 시작 시간을 2순위로 하여 오름차순 정렬했기 때문에,
        // 가장 먼저 끝나는 작업을 먼저 진행하고, 그 중에서도 가장 먼저 시작하는 작업을 진행해 유휴시간을 줄인다.
        for(Meeting m : meetings){
            if(m.start >= lastEnd){
                count ++;
                lastEnd = m.end;
            }
        }
        System.out.println(count);
    }

}