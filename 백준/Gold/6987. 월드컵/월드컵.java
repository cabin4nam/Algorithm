import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
조건 1. 모든 팀이 서로 경기를 해야한다 -> 한 팀 당 5번의 경기를 해야하기 때문에, 각 국가가 승리, 무승부, 패배한 수의 합이 5가 되어야 한다.
조건 2. 총 15번의 경기를 해야한다. (A-B,C,D,E,F / B - C,D,E,F / C - D,E,F / D- E,F / E-F)
조건 3. 정해진 두 팀이 경기를 했을 때, 각 팀이 승리, 무승부, 패배 했을 경우 중 가능한 경우가 있어야 한다.

설계
1. 모든 경기의 경우의 수를 구하고, 각 경우에서 다시 승리, 무승부, 패배하는 경우에 따른 조합을 탐색
2. 조합을 구해, depth가 15일 떄 (즉, 두 팀이 서로 경기를 하는 모든 경우의 수를 탐색했을 때) 성공으로 판별

 */
public class Main {
    private static int win[],lose[],draw[];
    private static int t1[],t2[];
    private static boolean avail;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        // 서로 경기를 할 두 팀 t1[0] vs t2[0] , t1[1] vs t2[1]
        t1 = new int[15];
        t2 = new int[15];

        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                t1[idx] = i;
                t2[idx++] = j;
            }
        }

        // 4개의 결과를 입력받기
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            win = new int[6];
            lose = new int[6];
            draw = new int[6];

            avail = false;
            int totalGames = 0;
            for(int j=0; j<6; j++){
                win[j] = Integer.parseInt(st.nextToken());
                draw[j] = Integer.parseInt(st.nextToken());
                lose[j] = Integer.parseInt(st.nextToken());

                totalGames += win[j] + draw[j] + lose[j];
            }

            if(totalGames != 30) avail = false;
            else dfs(0);

            if(avail) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx){
        if(avail) return; // 가능한 경우, 즉시 종료하여 최적화 (백트래킹)
        if(idx == 15){;
            avail = true;
            return;
        }

        int a = t1[idx];
        int b = t2[idx];

        // a가 이기는 경우
        if(win[a] > 0 && lose[b]>0){
            win[a] --;
            lose[b] --;
            dfs(idx+1);
            // 불가능한 경우, 다시 돌아와 다른 케이스를 탐색 (백트래킹)
            win[a]++;
            lose[b] ++;
        }

        // a와 b가 비기는 경우
        if(draw[a]>0 && draw[b]>0){
            draw[a] --;
            draw[b] --;
            dfs(idx+1);
            draw[a] ++;
            draw[b] ++;
        }

        // a가 지는 경우
        if(lose[a] >0 && win[b] > 0){
            lose[a] --;
            win[b] --;
            dfs(idx+1);
            lose[a]++;
            win[b] ++;
        }
    }
}