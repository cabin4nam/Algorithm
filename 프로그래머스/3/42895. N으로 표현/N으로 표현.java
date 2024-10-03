import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        // index는 사용한 N의 개수
        // ex. List.get(1) -> N을 1개 사용해서 나올 수 있는 숫자의 모든 경우의 수
        // 중복된 값을 삽입하지 않도록 하기 위해 Set 사용
        List<Set<Integer>> setList = new ArrayList<>();
        
        // 8개 이상의 N을 쓰면 -1 반환이므로 그 전까지 수행
        for(int i=0; i<9; i++){
            setList.add(new HashSet<>());
        }
        
        setList.get(1).add(N); // N 1개로 만들 수 있는 것은 N 자신 뿐4
        
        if(number == N) return 1; // 1개로 만들 수 있는 값이라면 바로 반환
        
        // 내가 항상 틀렸던 부분 : 괄호가 있는 경우 ex. (5,26) -> 4 ((5/5) + (5*5))
        for(int i=2; i<9; i++){
            for(int j=1; j<=i/2; j++){
                unionSet(setList.get(i), setList.get(i-j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i-j));
            }
            // 연속된 숫자 넣기 -> 55, 555, 5555
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));
            for(int num : setList.get(i)){
                if(num==number) return i;
            }
        }
            
        
        return -1;
    }
    
    // 두 Set을 합치기
    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b){
        for(int n1 : a){
            for(int n2 : b){
                // n1과 n2로 만들 수 있는 모든 수의 경우를 삽입
                union.add(n1+n2); 
                union.add(n1-n2);
                union.add(n1*n2);
                if(n2!=0) union.add(n1/n2);
            }
        }
    }
}