import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int minTime = 987654321;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수빈이가 동생보다 뒤에 있으면 -> 앞으로 1초에 1칸씩 움직이는 방법뿐
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime + "\n" + count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N); // 수빈이의 현재 위치 저장
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll(); // 현재 위치

            // now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (minTime < time[now]) return; // 어차피 최소로 갱신될 수 없음

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1; // 뒤로 한칸 이동
                else if (i == 1)    next = now - 1; // 앞으로 한칸 이동
                else                next = now * 2; // 뒤로 2배 이동

                if (next < 0 || next > 100000) continue; // 이동 가능한 범위를 넘어섰을 때

                // 동생이 있는 곳에 도착하면
                if (next == K) {
                    minTime = time[now]; // 최소 시간을 저장
                    count++;
                }

                // 첫 방문이거나 (time[next] == 0)
                // 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1)
                // 경우의 수에 추가될 수 있기 때문에 Queue 에 한번 더 넣어줌
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}

