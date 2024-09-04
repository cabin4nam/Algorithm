import java.io.*;
import java.util.*;

class Main {
    private static ArrayList<Character>[] wheels;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheels = new ArrayList[5];

        for(int i=1; i<=4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(wheels[i] == null) wheels[i] = new ArrayList<>(8);

            for(int j=0; j<8; j++)
                wheels[i].add(str.charAt(j));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken()); // 회전시킬 톱니 번호
            int dir = Integer.parseInt(st.nextToken()); // 회전방향

            // 회전시키기
            visited = new boolean[5];
            rotateWheel(wheelNum, dir);
        }

        int answer = 0;

        // 점수 계산
        if(wheels[1].get(0) == '1') answer += 1;
        if(wheels[2].get(0) == '1') answer += 2;
        if(wheels[3].get(0) == '1') answer += 4;
        if(wheels[4].get(0) == '1') answer += 8;

        System.out.println(answer);
    }

    private static void rotateWheel(int wheelNum, int dir){
        // 현재 톱니 회전시키기
        if(wheelNum < 1 || wheelNum > 4 || visited[wheelNum]) return;

        visited[wheelNum] = true;

        // 양쪽 톱니 회전
        // 왼쪽
        if(wheelNum > 1 && !visited[wheelNum-1]) {
            if(wheels[wheelNum-1].get(2)!=wheels[wheelNum].get(6)) rotateWheel(wheelNum-1, -dir);
        }
        //오른쪽
        if(wheelNum < 4 && !visited[wheelNum+1]) {
            if(wheels[wheelNum+1].get(6)!=wheels[wheelNum].get(2)) rotateWheel(wheelNum+1, -dir);
        }

        // 현재 톱니 회전
        if(dir == 1){ // 시계방향
            char temp = wheels[wheelNum].remove(7);
            wheels[wheelNum].add(0, temp);
        }
        else if(dir == -1){ // 반시계방향
            char temp = wheels[wheelNum].remove(0);
            wheels[wheelNum].add(7, temp);
        }

    }
}