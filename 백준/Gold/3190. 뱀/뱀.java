
// 사과를 먹으면 뱀 길이가 늘어남
// 자기자신의 몸 또는 벽과 부딪히면 게임이 끝남
// 뱀의 처음 상태 : 맨위/맨좌측에 위치, 길이는 1, 처음에 오른쪽을 향함
// 매 초마다 이동
    // 1. 몸길이를 늘려 머리를 다음칸에 위치
    // 2. 벽이나 자기 자신의 몸과 부딪히면 게임 끝
    // 3-1. 이동한 칸에 사과가 있으면, 사과 없어지고 꼬리는 움직이지 X
    // 3-2. 이동한 칸에 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸을 비워줌 (=몸길이 변화 X)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        //사과가 있는 위치는 1로 초기화
        for(int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        //시간에 따라서 회전시킬 방향 queue 생성
        Queue<spin> spin = new LinkedList<>();
        for(int i = 0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            spin.offer(new spin(time, dir));
        }

        //0은 북, 1은 동, 2는 남, 3은 서 의미
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        //초기 (1, 1)에서 시작하고 동쪽을 보고 시작
        int row = 1;
        int col = 1;
        int time = 0;
        int dir = 1;
        Queue<Node> q  = new LinkedList<>();
        q.offer(new Node(row, col));
        map[row][col] = 2;

        while(true){
            int dR = row + dr[dir];
            int dC = col + dc[dir];

            time++;

            if(dR<1||dC<1||dR>N||dC>N)
                break;
            if(map[dR][dC] == 2)
                break;

            if(map[dR][dC] == 0){
                Node node = q.poll();
                map[node.row][node.col] = 0;
            }
            if(!spin.isEmpty()) {
                if (time == spin.peek().time) {
                    spin s = spin.poll();

                    if (s.dir.equals("L"))
                        dir = dir-1 < 0 ? 3 : dir-1;
                    if (s.dir.equals("D"))
                        dir = dir+1 > 3 ? 0 : dir+1;
                }
            }

            map[dR][dC] = 2;
            q.offer(new Node(dR, dC));
            row = dR;
            col = dC;
        }

        System.out.println(time);
    }
}
class spin{
    int time;
    String dir;

    spin(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}

class Node{
    int row, col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
