import java.util.HashSet;
class Solution {
    private static int SIZE = 32001;
    public int solution(int N, int number) {
        int answer = 0;
        
        // number를 N을 사용해서 표현
        // N을 사용하여 만들 수 있는 것들을 저장, number를 만나면 answer로 지정 후 빠져나가기
        // dp의 index : 사용한 N의 개수
        HashSet<Integer>[] dp = new HashSet[SIZE];
        
        dp[1] = new HashSet<>();
        dp[1].add(N);
        if(N==number) return 1;

        for(int index =2; index<9; index++){
            dp[index] = new HashSet<>();
            // N inedex개 합친 수
            int conti = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<index; i++)
                sb.append(String.valueOf(N));
            dp[index].add(Integer.parseInt(sb.toString()));
            
            for(int i=1; i<index; i++){
                for(int n1 : dp[i]){
                    for(int n2 : dp[index-i]){
                        // 더하기
                        dp[index].add(n1+n2);
                        
                        // 빼기
                        dp[index].add(n1-n2);
                        
                        // 곱하기
                        dp[index].add(n1*n2);
                        
                        // 나누기
                        if(n2 != 0) dp[index].add(n1/n2);
                    }
                }
            }
            
            for(int n : dp[index]){
                if(n==number){
                    return index;
                } 
            } 
        }
        
        return -1;
    }
}