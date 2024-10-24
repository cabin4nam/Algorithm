import java.io.*;
import java.util.*;

public class Main{
    private static int[][] map;
    private static int answer;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        move(0, map); // 최대 5번 이동
        System.out.println(answer); // 최종 답
    }

    private static void move(int depth, int[][] map) {
        if (depth == 5) {
            // 현재 보드에서 최대값 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, map[i][j]);
                }
            }
            return;
        }

        // 4방향 모두 시도
        for (int i = 0; i < 4; i++) {
            int[][] newMap = moveDirection(map, i);
            move(depth + 1, newMap); // 재귀 호출
        }
    }

    private static int[][] moveDirection(int[][] map, int dir) {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, n);
        }

        switch (dir) {
            case 0: // 왼쪽
                for (int i = 0; i < n; i++) {
                    newMap[i] = mergeLine(newMap[i]);
                }
                break;
            case 1: // 오른쪽
                for (int i = 0; i < n; i++) {
                    newMap[i] = reverse(mergeLine(reverse(newMap[i])));
                }
                break;
            case 2: // 위쪽
                newMap = transpose(newMap);
                for (int i = 0; i < n; i++) {
                    newMap[i] = mergeLine(newMap[i]);
                }
                newMap = transpose(newMap);
                break;
            case 3: // 아래쪽
                newMap = transpose(newMap);
                for (int i = 0; i < n; i++) {
                    newMap[i] = reverse(mergeLine(reverse(newMap[i])));
                }
                newMap = transpose(newMap);
                break;
        }
        return newMap;
    }

    private static int[] mergeLine(int[] line) {
        LinkedList<Integer> merged = new LinkedList<>();
        boolean[] mergedFlag = new boolean[n];
        int[] newLine = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (line[i] != 0) {
                if (!merged.isEmpty() && merged.getLast() == line[i] && !mergedFlag[merged.size() - 1]) {
                    merged.removeLast();
                    merged.add(line[i] * 2);
                    mergedFlag[merged.size() - 1] = true;
                } else {
                    merged.add(line[i]);
                }
            }
        }

        for (int i = 0; i < merged.size(); i++) {
            newLine[i] = merged.get(i);
        }
        return newLine;
    }

    private static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return newArr;
    }

    private static int[][] transpose(int[][] map) {
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = map[j][i];
            }
        }
        return transposed;
    }
}
