import java.util.*;

class Solution {
    private class Task{
        int start;
        int duration;
        public Task(int start, int duration){
            this.start = start;
            this.duration = duration;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        // jobs 시작 시간 기준 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] j1, int[] j2){
                if(j1[0]==j2[0]) return j1[1] - j2[1];
                else return j1[0]-j2[0];
            }
        });
        
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                if(t1.duration == t2.duration) return t1.start - t2.start;
                else return t1.duration - t2.duration;
            }
        });
        
        int taskIdx = 0;
        while (taskIdx < jobs.length || !pq.isEmpty()) {
            // 큐가 비어있고 남은 작업이 있다면, 다음 작업을 큐에 추가하고 현재 시간을 조정
            if (pq.isEmpty() && taskIdx < jobs.length) {
                pq.offer(new Task(jobs[taskIdx][0], jobs[taskIdx][1]));
                time = jobs[taskIdx][0];
                taskIdx++;
            }

            // 가장 우선순위가 높은 작업을 가져와 처리
            if (!pq.isEmpty()) {
                Task task = pq.poll();
                answer += (time - task.start) + task.duration; // 대기 시간 + 작업 시간
                time += task.duration;
            }

            // 현재 시간 내에 시작할 수 있는 작업들을 모두 큐에 추가
            while (taskIdx < jobs.length && jobs[taskIdx][0] <= time) {
                pq.offer(new Task(jobs[taskIdx][0], jobs[taskIdx][1]));
                taskIdx++;
            }
        }

        
        answer /= jobs.length;
        
        return answer;
    }
}

// import java.util.*;

// class Solution {
//     private class Task{
//         int start;
//         int duration;
//         public Task(int start, int duration){
//             this.start = start;
//             this.duration = duration;
//         }
//     }
//     public int solution(int[][] jobs) {
//         int answer = 0;
//         int time = 0;
        
//         // jobs 시작 시간 기준 오름차순 정렬
//         Arrays.sort(jobs, new Comparator<int[]>(){
//             @Override
//             public int compare(int[] j1, int[] j2){
//                 if(j1[0]==j2[0]) return j1[1] - j2[1];
//                 else return j1[0]-j2[0];
//             }
//         });
        
//         PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
//             @Override
//             public int compare(Task t1, Task t2){
//                 if(t1.duration == t2.duration) return t1.start - t2.start;
//                 else return t1.duration - t2.duration;
//             }
//         });
        
//         int taskIdx = 1;
//         pq.offer(new Task(jobs[0][0], jobs[0][1]));
//         time = jobs[0][0];
        
//         while(!pq.isEmpty()){
//             Task task = pq.poll();
            
//             System.out.println("=======" + task.start + " // " + task.duration + " ========= ");
            
//             answer += (time-task.start) + task.duration;
//             time += task.duration;
            
//             System.out.println("time : " + time + " // answer : " + answer);
            
//             // task가 끝나기 전에 들어온 새로운 작업들을 모두 큐에 넣어주기
//             while(taskIdx < jobs.length && jobs[taskIdx][0] <= time){
//                 pq.offer(new Task(jobs[taskIdx][0], jobs[taskIdx][1]));
//                 taskIdx ++;
//             }
//         }
        
//         answer /= jobs.length;
        
//         return answer;
//     }
// }