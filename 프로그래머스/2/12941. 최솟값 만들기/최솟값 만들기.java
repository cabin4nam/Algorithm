// sort 사용 -> 효율성 시간초과
// import java.util.*;
// class Solution
// {
//     public int solution(int []A, int []B)
//     {
//         int answer = 0;

//         // A를 오름차순 정렬
//         Arrays.sort(A);
        
//         // B를 내림차순 정렬
//         Integer[] tmp = Arrays.stream(B).boxed().toArray(Integer[]::new);
//         Arrays.sort(tmp, Comparator.reverseOrder()); // 내림차순
        
//         // 서로 짝지은 인덱스끼리 곱해서 더해주기
//         for(int i=0; i<A.length; i++){
//             answer += A[i] * tmp[i];
//         }

//         return answer;
//     }
// }

// PriorityQueue 사용
// import java.util.*;
// class Solution
// {
//     public int solution(int []A, int []B)
//     {
//         int answer = 0;

//         PriorityQueue<Integer> pq_a = new PriorityQueue<>();
//         PriorityQueue<Integer> pq_b = new PriorityQueue<>();
        
//         for(int i=0; i<A.length; i++){
//             pq_a.offer(A[i]);
//             pq_b.offer(B[i]);
//         }
        
//         while(!pq_a.isEmpty() && !pq_b.isEmpty()){
//             answer += pq_a.poll() * pq_b.poll();
//         }

//         return answer;
//     }
// }

import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        
        // 배열 A와 B를 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            // 배열 A는 순서대로, 배열 B는 역순으로 접근하여 곱하여 answer에 더함
            answer += A[i] * B[B.length - i - 1];
        }
        
        return answer;
    }
}