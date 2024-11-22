import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;
        
        // 전체 보석 종류 수 구하기
        Set<String> set = new HashSet<>();
        for(String g : gems){
            set.add(g);
        }
        
        int typeCnt = set.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        int startPointer = 0;
        int endPointer = 0;
        map.put(gems[startPointer], 1);
        
        while(startPointer < gems.length){
            // 만약 startPointer ~ endPointer 안에 모든 종류의 보석이 있다면
            if(map.keySet().size() == typeCnt){
                // 정답을 더 짧은 길이로 갱신
                if(answer[1] - answer[0] > endPointer-startPointer){
                    answer[0] = startPointer+1;
                    answer[1] = endPointer+1;
                }
                
                map.put(gems[startPointer], map.get(gems[startPointer])-1);
                if(map.get(gems[startPointer])==0) map.remove(gems[startPointer]);
                
                // 더 짧은 구간에서도 모든 종류의 보석이 있을 수 있는지 확인 (구간 줄이기=start++)
                startPointer++;
            }
            // 구간을 늘릴 수 있다면, 더 긴 영역에서 보석 개수 구해보기 (구간 늘리기=end++)
            else if(endPointer+1 < gems.length){
                endPointer++;
                map.put(gems[endPointer], map.getOrDefault(gems[endPointer], 0)+1);
            }
            else{
                break;
            }
        }
        
        return answer;
    }
}

// import java.util.*;

// class Solution {
//     public int[] solution(String[] gems) {
//         int[] answer = new int[2];
//         int minLength = Integer.MAX_VALUE;
        
//         HashMap<String, Integer> map = new HashMap<>();
//         // 전체 보석 종류 저장하기
//         for(String g : gems){
//             map.put(g, map.getOrDefault(g, 0) + 1);
//         }
        
//         int start = 0;
//         int end = gems.length-1;
        
//         while(start <= end){
//             // end를 없앴을 때 몇 가지?
//             if(map.get(gems[end]) - 1 > 0){ 
//                 map.put(gems[end], map.get(gems[end])-1);
//                 end --;
//             }
//             // start를 없앴을 때 몇 가지?
//             else if(map.get(gems[start]) - 1 > 0){
//                 map.put(gems[start], map.get(gems[start])-1);
//                 start ++;
//             }
            
            
//             else break;
//         }
        
//         answer[0] = start+1;
//         answer[1] = end+1;
        
//         return answer;
//     }
// }

// import java.util.*;

// class Solution {
//     public int[] solution(String[] gems) {
//         int[] answer = new int[2];
//         int minLength = Integer.MAX_VALUE;
        
//         Set<String> types = new HashSet<>();
//         // 전체 보석 종류 개수 구하기
//         for(String g : gems){
//             types.add(g);
//         }
        
//         int typeCnt = types.size();
        
//         for(int unit=typeCnt; unit<=gems.length; unit++){
//             for(int start = 0; start+unit<=gems.length; start++){
//                 Set<String> set = new HashSet<>();
                
//                 for(int i=start; i<start+unit; i++){
//                     set.add(gems[i]);
//                 }
                
//                 if(set.size() >= typeCnt && minLength > unit){
//                     answer[0] = start+1;
//                     answer[1] = start+unit;
//                     minLength = unit;
//                     break;
//                 } 
//             }   
//         }
        
        
//         return answer;
//     }
// }