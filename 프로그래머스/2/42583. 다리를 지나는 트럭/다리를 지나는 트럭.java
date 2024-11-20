import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        int weightSum = 0;
        for(int truck : truck_weights){
            if(bridge.isEmpty()){
                bridge.offer(truck);
                weightSum += truck;
            }
            else{
                while(true){
                    // 자리가 없는 경우
                    if(bridge.size() >= bridge_length){
                        int temp = bridge.poll();
                        weightSum -= temp;
                    }

                    // 자리는 있는데 무게가 안되는 경우
                    else if(weightSum + truck > weight){
                        bridge.offer(0);
                        time++;
                    }
                    // 다리에 올릴 수 있는 경우
                    else{
                        bridge.offer(truck);
                        weightSum += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        
        time+=bridge_length+1;
        
        return time;
    }
}