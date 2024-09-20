/**
최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다.
한 번 사용한 객실은 퇴실 시간 기준 10분간 청소하고 다음 손님이 사용

시간을 숫자로 표현 필요
시작 시간 기준 book_time 정렬

1. 방 사용 (썼던 방 중 사용가능한 게 있으면 1-2, 아니면 1-1)
- 썼던 방 인덱스 : 스택에 저장
- 썼던 방 사용가능 여부 - int 배열 (사용 가능한 시간 저장)
    1-1. 새로운 방 사용
        - 사용한 방 카운트 + 1
    1-2. 썼던 방 사용
        - 
**/
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int n = book_time.length;
        int[][] book_time_num = new int[n][2];
        
        changeTimeToNum(book_time, book_time_num);
        
        // 시작 시간 기준 book_time 정렬
        Arrays.sort(book_time_num, new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                if(n1[0] > n2[0]) return 1;
                else if(n1[0] < n2[0]) return -1;
                else{
                    if(n1[1] > n2[1]) return 1;
                    else if(n1[1] < n2[1]) return -1;
                }
                return 0;
            }
        });
        
        List<Integer> newRoom = new ArrayList<>();
        for(int i=0; i<n; i++) newRoom.add(i);
        
        List<Integer> usedRoom = new ArrayList<>();
        
        Map<Integer, Integer> roomStatus = new HashMap<>(); // idx , 사용 가능 시간
        for(int i=0; i<n; i++) roomStatus.put(i, 0);
        
        for(int[] room : book_time_num){
            boolean used = false;
            if(!usedRoom.isEmpty()) { // 썼던 방 사용가능
                for(int r : usedRoom){
                    if(roomStatus.get(r) <= room[0]){ // 쓸 수 있으면
                        roomStatus.put(r,room[1]+10);
                        used = true;
                        break;
                    }
                }

            }
            
            if(!used){
                roomStatus.put(newRoom.get(0), room[1]+10);
                usedRoom.add(newRoom.get(0));
                newRoom.remove(0);
            }
        }
        
        
        return usedRoom.size();
    }
    
     // 문자열 시간을 숫자로 변환
    public void changeTimeToNum(String[][] book_time, int[][] book_time_num){
        for(int i=0; i<book_time.length; i++){
            int start_hour = Integer.parseInt(book_time[i][0].substring(0,2));
            int start_min = Integer.parseInt(book_time[i][0].substring(3,5));
            int start = (start_hour * 60) + (start_min);
            
            int end_hour = Integer.parseInt(book_time[i][1].substring(0,2));
            int end_min = Integer.parseInt(book_time[i][1].substring(3,5));
            int end = (end_hour * 60) + (end_min);
            
            book_time_num[i][0] = start;
            book_time_num[i][1] = end;
        }
    }
}