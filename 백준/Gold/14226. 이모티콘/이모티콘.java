import java.util.*;
import java.io.*;

class Main {
    static class Emo{
        int clip;
        int cnt;
        int time;

        public Emo(int clip, int cnt, int time){
            this.clip = clip;
            this.cnt = cnt;
            this.time  = time;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        int answer = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[2001][2001];
        Queue<Emo> q = new LinkedList<>();
        q.offer(new Emo(1, 1, 1));

        while(!q.isEmpty()){
            Emo emo = q.poll();

            if(emo.cnt == S){
                answer = Math.min(answer, emo.time);
                break;
            }

            if(visited[emo.cnt][emo.clip]) continue;

            visited[emo.cnt][emo.clip] = true;
            // 클립보드에 현재 emo 복사
            q.offer(new Emo(emo.cnt, emo.cnt, emo.time+1));

            // 클립보드에 있는 모든 emo를 붙여넣기
            if(emo.clip >0 && emo.clip + emo.cnt <= S)
                q.offer(new Emo(emo.clip, emo.cnt+emo.clip, emo.time+1));

            // 화면에 있는 이모티콘 중 한 개를 삭제
            if(emo.cnt > 1)
                q.offer(new Emo(emo.clip, emo.cnt-1, emo.time+1));

        }

        System.out.println(answer);
    }
}

