import java.util.*;
class Solution {
    private static class Job{
        int start;
        int time;
        public Job(int start, int time){
            this.start = start;
            this.time = time;
        }
    }
    private static int count = 0;
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // jobs를 시작 시간 기준 정렬
        Arrays.sort(jobs, (j1, j2) -> j1[0]-j2[0]);
        int jobsIdx = 0; // jobs 배열의 인덱스
        int time = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                if(j1.time == j2.time) return j1.start-j2.start;
                else return j1.time-j2.time;
            }
        });
        
        while(count < jobs.length){
            if(pq.isEmpty()){
                time = jobs[jobsIdx][0];
            }
            else{
                Job j = pq.poll(); // 작업 실행
                count ++;
                time += j.time;
                answer += time-j.start;
            }
            
            // j가 끝나기 전에 시작되는 작업들 넣기
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= time) {
				pq.add(new Job(jobs[jobsIdx][0], jobs[jobsIdx][1]));
                jobsIdx++;
			}
            
        }
        
        
        return answer/jobs.length;
    }
}