import java.util.*;

class Solution {
    private static class Job {
        int start;
        int time;
        
        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int jobCount = jobs.length;

        // 요청 순으로 정렬
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.time));

        while (idx < jobCount || !pq.isEmpty()) {
            // 현재 시점까지 요청된 작업을 모두 큐에 추가
            while (idx < jobCount && jobs[idx][0] <= time) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // 작업 가능 상태면 진행
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.time; // 작업 소요 시간 추가
                answer += time - job.start; // 요청부터 종료까지 걸린 시간 계산
            } else {
                // 처리할 작업이 없으면 시간 이동
                time = jobs[idx][0];
            }
        }
        
        return answer / jobCount;
    }
}
