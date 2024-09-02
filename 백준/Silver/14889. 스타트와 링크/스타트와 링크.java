import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    private static int minGap = Integer.MAX_VALUE;
    private static int playerCnt;
    private static ArrayList<Integer> teamStart;
    private static ArrayList<Integer> teamLink;
    private static int[][] power;
    private static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        playerCnt = Integer.parseInt(st.nextToken());

        power = new int[playerCnt][playerCnt];
        visit = new boolean[playerCnt];
        for(int i=0; i<playerCnt; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<playerCnt; j++){
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
            // 팀 만들기
        makeTeam(0,0);

        System.out.println(minGap);
    }
    
    private static void makeTeam(int idx, int count){
        // 팀 조합이 완성될 경우
        if(count == playerCnt/2){
            // 스타트 팀 (=방문한 팀), 링크 팀(=방문하지 않은 팀)을 나누어, 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
            
            powerDiff();
            return;
        }
        
        for(int i=idx; i<playerCnt; i++){
            // 방문하지 않았을 때
            if(!visit[i]){
                visit[i] = true; // 방문으로 변경
                makeTeam(i+1, count+1); // 재귀 호출
                visit[i] = false; //재귀가 끝나면 방문 안함으로 변경
            }
        }
    }

    private static void powerDiff(){
        int powerOfStart = 0;
        int powerOfLink = 0;

        for(int i=0; i<playerCnt-1; i++){
            for(int j=i+1; j<playerCnt; j++){
                // i번째 사람과 j번째 사람이 true라면 스타트팀으로 점수 플러스
                if(visit[i] && visit[j]){
                    powerOfStart += power[i][j];
                    powerOfStart += power[j][i];
                }
                // i번째 사람과 j번째 사람이 false라면 링크팀으로 점수 플러스
                else if(!visit[i] && !visit[j]){
                    powerOfLink += power[i][j];
                    powerOfLink += power[j][i];
                }
            }
        }

        // 두 팀의 점수 차이
        int diff = Math.abs(powerOfStart-powerOfLink);

        minGap = Math.min(diff, minGap);

    }
}