import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            
            while(true){
                if(bridge.isEmpty()){ // 다리에 아무것도 없는 경우 : 트럭 올릴 수 있음
                    bridge.offer(truck);
                    bridgeWeight += truck;
                    answer ++;
                    break;
                }
                else if(bridge.size() == bridge_length){ // 다리가 꽉 찬 경우 : 트럭 하나 out.
                    bridgeWeight -= bridge.poll();
                }
                else{ 
                    if(bridgeWeight + truck <= weight){ // 다리에 현재 트럭을 올려도 무게 초과가 되지 않는 경우 : 트럭 올려주기
                        bridge.offer(truck);
                        bridgeWeight += truck;
                        answer ++;
                        break;
                    }
                    else {
                        bridge.offer(0); // 다리 위의 무게 초과로 트럭 올릴 수 없음 : 빈 값을 넣어서 다리 채워주기
                        answer++;
                    }
                    
                }
            }
            
        }
        
        answer += bridge_length;
        
        return answer;
    }
}