import java.io.*;
import java.util.*;

public class Main {
    private static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int ROWS = 12, COLS = 6;
    private static char[][] map = new char[ROWS][COLS];
    private static boolean[][] visited;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<Point> removeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필드 입력 받기
        for (int i = 0; i < ROWS; i++) {
            String line = br.readLine();
            for (int j = 0; j < COLS; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int chainCount = 0; // 연쇄 횟수

        while (true) {
            boolean popped = false; // 이번 턴에 뿌요가 터졌는지 여부
            visited = new boolean[ROWS][COLS];
            removeList = new ArrayList<>();

            // 필드 전체를 돌며 4개 이상 뭉쳐있는 뿌요 찾기
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        List<Point> group = bfs(i, j);
                        if (group.size() >= 4) {
                            popped = true;
                            removeList.addAll(group); // 터질 뿌요들 추가
                        }
                    }
                }
            }

            // 터질 뿌요가 없다면 종료
            if (!popped) break;

            // 뿌요 터뜨리기
            for (Point p : removeList) {
                map[p.r][p.c] = '.';
            }

            // 중력 처리 (아래로 떨어뜨리기)
            applyGravity();

            chainCount++; // 연쇄 횟수 증가
        }

        System.out.println(chainCount);
    }

    // BFS로 연결된 뿌요 그룹 찾기
    private static List<Point> bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> group = new ArrayList<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;
        char color = map[r][c];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            group.add(p);

            for (int[] dir : directions) {
                int nr = p.r + dir[0];
                int nc = p.c + dir[1];

                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc] && map[nr][nc] == color) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
        }

        return group;
    }

    // 중력 적용하여 뿌요 떨어뜨리기
    private static void applyGravity() {
        for (int c = 0; c < COLS; c++) {
            Queue<Character> queue = new LinkedList<>();
            // 아래에서부터 남아있는 뿌요들을 큐에 저장
            for (int r = ROWS - 1; r >= 0; r--) {
                if (map[r][c] != '.') {
                    queue.offer(map[r][c]);
                }
            }
            // 큐에서 꺼내면서 아래부터 차례대로 뿌요 채우기
            for (int r = ROWS - 1; r >= 0; r--) {
                if (!queue.isEmpty()) {
                    map[r][c] = queue.poll();
                } else {
                    map[r][c] = '.';
                }
            }
        }
    }
}
