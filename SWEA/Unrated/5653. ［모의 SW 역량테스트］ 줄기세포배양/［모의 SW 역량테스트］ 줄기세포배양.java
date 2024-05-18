import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
 
    static final int MOD = 1_000;
 
    static int N, M, K, cnt;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
 
    static boolean[][] map;
    static Cell[] cell;
 
    static class Cell {
        int x, y;
        int life;
        Cell next = null;
 
        public Cell() {};
 
        public Cell(int x, int y, int life, Cell next) {
            this.x = x;
            this.y = y;
            this.life = life * 2;
            this.next = next;
        }
    }
 
    public static void culture() {
 
        for (int i = 0; i < K; i++) {
            for (int j = 10; j > 0; j--) {
                for (Cell curCell = cell[j]; curCell != null; curCell = curCell.next) {
                    if (curCell.life == 0) {
                        curCell = null;
                        break;
                    }
 
                    curCell.life--;
                    if (curCell.life >= j) {
                        continue;
                    }
 
                    if (curCell.life == 0) cnt--;
                    for (int d = 0; d < 4; d++) {
                        int nx = curCell.x + dx[d];
                        int ny = curCell.y + dy[d];
                         
                        if (map[nx][ny]) continue;
                        map[nx][ny] = true;
                         
                        cell[j] = new Cell(nx, ny, j, cell[j]);
                        cnt++;
                    }
 
                }
 
            }
 
        }
         
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            cnt = 0;
            cell = new Cell[11];
            for (int i = 0; i < 11; i++) {
                cell[i] = new Cell();
            }
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
 
            map = new boolean[N + K][M + K];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int cur = Integer.parseInt(st.nextToken());
                    if (cur == 0)
                        continue;
                     
                    map[i + K / 2][j + K / 2] = true;
                    cell[cur] = new Cell(i + K / 2, j + K / 2, cur, cell[cur]);
                    cnt++;
                }
            }
 
            culture();
            sb.append("#" + tc + " " + cnt + "\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}