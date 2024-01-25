import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int answer = 0;
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] computers  = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            computers[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            computers[c1].add(c2);
            computers[c2].add(c1);
        }

        // 초기 세팅
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        for(int computer : computers[1]){
            visited[computer] = true;
            q.add(computer);
        }

        while(!q.isEmpty()){
            int c = q.poll();
            answer ++;

            for(int nextComputer : computers[c]){
                if(!visited[nextComputer]){
                    visited[nextComputer] = true;
                    q.add(nextComputer);
                }
            }

        }

        System.out.println(answer);

    }
}