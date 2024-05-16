import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 스테이지 별 도전자 수를 구함
        int[] challenger = new int[N+2];
        for(int i=0; i<stages.length; i++){
            challenger[stages[i]] += 1;
        }
        
        // 스테이지 별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        for(int i=1; i<=N; i++){
            if(challenger[i] == 0){
                fails.put(i, 0.0);
            }
            else {
                fails.put(i, challenger[i]/total);
                total -= challenger[i]; // 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }
        
        // 실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet().stream().sorted((o1, o2) -> 
                Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
        // .entrySet() : Map에서 모든 Entry(key-value쌍)을 가져와 Set 객체로 반환 (-> foreach 루프를 사용하여 각 Entry에 순차적으로 접근 가능)
        //.stream() : 데이터 소스를 추상화, 데이터를 다루는데 자주 사용 사용되는 메소드를 정의해 놓아서, 데이터 소스에 상관없이 모두 같은 방식으로 다룰 수 있음 (ex. List 정렬할 때는 Collections.sort()사용 vs 배열 정렬할 때는 Arrays.sort()사용 -> 같은 방식으로 다룰 수 있도록 하는 게 stream.)
        
    }
}