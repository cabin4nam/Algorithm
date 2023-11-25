class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //n이 최대 30이기 때문에 이중 반복문 문제 없을 것이라 판단
        
        int[] availRest = new int[n];
        for(int i=0; i<n; i++){
            availRest[i] = 0;
        }
        boolean[] needStudent = new boolean[n];
        for(int i=0; i<n; i++){
            needStudent[i] = false;
        }
        
        for(int i=0; i<n; i++){
            // 학생의 경우 조사
            boolean doLost = false;
            boolean haveRest = false;
            for(int l=0; l<lost.length; l++){
                if(lost[l] == i+1) doLost = true;
            }
            for(int r=0; r<reserve.length; r++){
                if(reserve[r] == i+1) haveRest = true;
            }
            
            // 여벌이 있고, 도난 O
            if(haveRest && doLost){
                answer ++;
            }
            // 여벌이 없고, 도난 O
            else if(!haveRest && doLost){
                needStudent[i] = true;
            }
            // 여벌이 있고, 도난 X
            else if(haveRest && !doLost){
                answer++;
                
                availRest[i] = availRest[i] + 1;
                
            }
            // 여벌이 없고, 도난 X
            else {
                answer++;
            }
        }
        
        // 체육복이 필요한 학생에게 여분의 체육복으로 빌려줄 수 있는지 확인
        for(int i=0; i<needStudent.length; i++){
            System.out.println(needStudent[i] + "//" + availRest[i]);
            // 체육이 필요한 학생이면
            if(needStudent[i]){
                if(i==0) {
                    if(availRest[i+1] >0){
                      answer++;
                        availRest[i+1] = availRest[i+1] -1;
                    } 
                }
                else if(i==n-1){
                    if(availRest[i-1] >0){
                      answer++;
                        availRest[i-1] = availRest[i-1] -1;
                    } 
                }
                else {
                    if(availRest[i-1] >0){
                      answer++;
                        availRest[i-1] = availRest[i-1] -1;
                    } 
                    else if(availRest[i+1] >0){
                        answer++;
                        availRest[i+1] = availRest[i+1] -1;
                    } 
                    
                }
            }
        }
        
        return answer;
    }
}