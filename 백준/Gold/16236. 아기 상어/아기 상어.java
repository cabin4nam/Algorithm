import java.io.*;
import java.util.*;

class Main {

    private static class BFSNode {
        int r;
        int c;
        int depth;

        public BFSNode(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    private static int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int sharkRow = 0;
        int sharkCol = 0;
        int sharkSize = 2;
        int eatingCnt = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkRow = i;
                    sharkCol = j;
                    map[i][j] = 0;
                }
            }
        }

        int distance = 0;

        while(true) {
            PriorityQueue<BFSNode> nextLocations = new PriorityQueue<>((o1, o2) ->
                    o1.depth != o2.depth ? Integer.compare(o1.depth, o2.depth) : (o1.r != o2.r ? Integer.compare(o1.r, o2.r) : Integer.compare(o1.c, o2.c))
            );
            boolean[][] visited = new boolean[n][n];
            nextLocations.add(new BFSNode(sharkRow, sharkCol, 0));
            BFSNode target = null;

            while(!nextLocations.isEmpty()) {
                BFSNode preLoc = nextLocations.poll();
                if(visited[preLoc.r][preLoc.c]) continue;
                visited[preLoc.r][preLoc.c] = true;

                if(map[preLoc.r][preLoc.c] > 0 && map[preLoc.r][preLoc.c] < sharkSize) {
                    target = preLoc;
                    break;
                }

                for(int i = 0; i < 4; i++) {
                    int nextRow = preLoc.r + move[i][0];
                    int nextCol = preLoc.c + move[i][1];

                    if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                    if(map[nextRow][nextCol] > sharkSize) continue;
                    if(visited[nextRow][nextCol]) continue;

                    nextLocations.add(new BFSNode(nextRow, nextCol, preLoc.depth + 1));
                }
            }

            if(target == null) break; // 먹을 수 있는 물고기가 더 이상 없음

            sharkRow = target.r;
            sharkCol = target.c;
            distance += target.depth;
            map[sharkRow][sharkCol] = 0;
            eatingCnt++;

            if(eatingCnt == sharkSize) {
                sharkSize++;
                eatingCnt = 0;
            }
        }

        System.out.println(distance);
    }
}
