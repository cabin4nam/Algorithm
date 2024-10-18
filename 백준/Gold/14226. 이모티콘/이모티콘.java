import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static class Icon{
        public int screen;
        public int clip;
        public int time;
        public Icon(int screen, int clip, int time){
            this.screen = screen;
            this.clip = clip;
            this.time = time;
        }
    }
    private static int S;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());

        makeIcon();
    }
    private static void makeIcon(){
        Queue<Icon> q = new LinkedList<>();
        q.offer(new Icon(1, 0, 0));

        visited = new boolean[1001][1001];

        while(!q.isEmpty()){
            Icon icon = q.poll();

            if(icon.screen > S) return;
            
            if(icon.screen == S){
                System.out.println(icon.time);
                return;
            }
            
            // 화면 -> 클립 복사
            q.offer(new Icon(icon.screen, icon.screen, icon.time+1));
            
            // 클립 -> 화면 붙여넣기
            if(icon.clip > 0 && icon.screen+icon.clip <= S && !visited[icon.clip][icon.screen+icon.clip]){
                visited[icon.clip][icon.screen + icon.clip] = true;
                q.offer(new Icon(icon.screen+icon.clip, icon.clip, icon.time+1));
            }
            
            // 화면 중 하나 삭제
            if(icon.screen > 0 && icon.screen-1 <= S && !visited[icon.clip][icon.screen-1]){
                visited[icon.clip][icon.screen-1] = true;
                q.offer(new Icon(icon.screen-1, icon.clip, icon.time+1));
            }
        }
    }
}