// // 12:45 ~ 
// class Solution {
//     private static boolean[] visited;
//     private static int count = 0;
//     private static int[] answer;
//     public int[] solution(int n, long k) {
//         answer = new int[n];
        
//         visited = new boolean[n+1];
//         dfs(n, k, 0, "");

//         return answer;
//     }
    
//     public void dfs(int n, long k, int depth, String result){
//         if(depth == n){
//             count ++;
            
//             if(count == k){
//                 // 지금까지 고른 것들을 answer로 반환
//                 for(int i=0; i<result.length(); i++){
//                     answer[i] = Integer.parseInt(result.substring(i, i+1));
//                 }
//                 return;
//             }
            
//         }
        
//         for(int i=1; i<=n; i++){
//             if(!visited[i]){
//                 visited[i] = true;
//                 dfs(n, k, depth+1, result+i);
//                 visited[i] = false;
//             }
//         }
//     }
// }

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        
        // 1부터 n까지의 숫자를 ArrayList에 추가
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;  // n! 계산
        }
        
        k--;  // k를 0-based index로 변경

        for (int i = 0; i < n; i++) {
            factorial /= (n - i);  // (n-i-1)! 계산
            int index = (int)(k / factorial);  // 현재 위치에서 선택할 사람의 인덱스
            answer[i] = numbers.get(index);  // 해당 인덱스의 사람을 선택
            numbers.remove(index);  // 선택된 사람은 리스트에서 제거
            k %= factorial;  // 나머지 k 값을 업데이트
        }

        return answer;
    }
}
