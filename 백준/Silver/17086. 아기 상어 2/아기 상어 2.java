import java.util.*;
import java.io.*;

class Main {
    static class Shark{
        int row;
        int col;

        public Shark(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int[][] map;
    static Queue<Shark> sharks;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    // 위, 아래, 왼쪽, 오른쪽, 좌상, 좌하, 우상, 우하
    static int[] moveRow = { -1, 1, 0, 0, -1 , 1, -1, 1};
    static int[] moveCol = { 0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row_size = Integer.parseInt(st.nextToken());
        int col_size = Integer.parseInt(st.nextToken());

        map = new int[row_size][col_size];
        visited = new boolean[row_size][col_size];
        sharks = new LinkedList<>();
        for(int i=0; i < row_size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<col_size; j++){
                int isShark = Integer.parseInt(st.nextToken());

                map[i][j] = isShark==1 ? 0 : -1;
                if(isShark==1) sharks.offer(new Shark(i, j));

            }
        }

        while(!sharks.isEmpty()){
            Shark sh = sharks.poll();
            visited[sh.row][sh.col] = true;

            for(int i=0; i<8; i++){
                int nextRow = sh.row + moveRow[i];
                int nextCol = sh.col + moveCol[i];

                if(nextRow < 0 || nextRow > row_size-1 || nextCol < 0 || nextCol > col_size-1) continue;

                if(map[nextRow][nextCol] != -1) continue;
                if(map[nextRow][nextCol] < map[sh.row][sh.col]+1){
                    map[nextRow][nextCol] = map[sh.row][sh.col]+1;
                }

                if(answer < map[nextRow][nextCol]) answer = map[nextRow][nextCol];

                sharks.offer(new Shark(nextRow, nextCol));
            }
        }


        System.out.println(answer);
    }

}

