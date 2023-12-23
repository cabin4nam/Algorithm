import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] world;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2차원 세계의 크기 입력받기
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // 2차원 세계를 2차원 배열의 형태로 저장 -> 0인 곳은 갈 수 없는 곳 (블록이 있어 고일 수 있는 가능성이 없는 곳)
        world = new int[h][w];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            int block = Integer.parseInt(st.nextToken());

            for(int b = 0; b<block; b++){
                world[h-b-1][i] = 1;
            }
        }

        // world 를 0행 부터 h행 까지,  오른쪽으로 이동하면서 고일 수 있는 물의 양 계산
        for(int i=0; i<h; i++){
            // 새로운 행을 탐색하기 시작할 때마다 변수들 초기화
            int index = 0;
            int count = 0;
            boolean flag = true;

            // i행의 0열 ~ w열 탐색
            while(index < w){
                if(world[i][index] == 0){ // 뚫려있으므로 고일 수 있음
                    if(index ==0) flag= false; // 뚫려있는 곳이 맨 왼쪽이라면 고일 수 없으므로 flag를 false로 설정 -> 그 다음 열에 위치한 블록들도 고일 수 없도록
                    else if(flag) count ++; // 맨 왼쪽이 뚫려 고일 수 없는 경우가 아니라면 count를 늘려 고일 수 있는 수에 누적
                }
                // 블록을 만나면 고인 물을 answer에 반영해주기
                else {
                    // 고일 수 없는 상태라면 answer에 반영 X
                    if(flag){
                        answer += count;
                        count = 0;
                    }
                    // 새로운 계산을 시작할 것이므로 flag를 true로 원상복귀
                    flag = true;
                }
                
                // 다음 열에 위치한 블록 검사
                index ++;
            }
        }

        System.out.println(answer);
    }
}