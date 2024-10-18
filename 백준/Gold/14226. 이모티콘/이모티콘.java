//import java.io.*;
//import java.util.*;
//
//public class Main {
//    private static int S;
//    private static boolean[][] visited; // visited[화면에 있는 이모티콘 수][클립보드에 있는 이모티콘 수]
//    private static int answer = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        S = Integer.parseInt(br.readLine());
//
//        visited = new boolean[1001][1001]; // 화면에 이모티콘 최대 1000개, 클립보드도 최대 1000개
//
//        dfs(1, 0, 0); // 초기 상태: 화면에 1개, 클립보드에 0개, 시간 0초
//
//        System.out.println(answer);
//    }
//
//    private static void dfs(int screen, int clipboard, int time) {
//        // 이미 S개의 이모티콘을 만들었으면 최소 시간 갱신
//        if (screen == S) {
//            answer = Math.min(answer, time);
//            return;
//        }
//
//        // 범위를 넘어서면 종료
//        if (screen <= 0 || screen > 1000) return;
//        if (visited[screen][clipboard]) return; // 이미 방문한 상태면 종료
//
//        visited[screen][clipboard] = true; // 현재 상태 방문 처리
//
//        // 1. 화면에 있는 이모티콘을 복사해서 클립보드에 저장 (복사 연산)
//        dfs(screen, screen, time + 1);
//
//        // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 (붙여넣기 연산)
//        if (clipboard > 0 && screen + clipboard <= 1000) {
//            dfs(screen + clipboard, clipboard, time + 1);
//        }
//
//        // 3. 화면에 있는 이모티콘 중 하나 삭제 (삭제 연산)
//        if (screen > 0) {
//            dfs(screen - 1, clipboard, time + 1);
//        }
//    }
//}


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