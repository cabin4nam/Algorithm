import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {        
        Stack<Integer> trash = new Stack<>();
        
        // 현재 위치에서 위로 이동했을 때와, 아래로 이동했을 때 인덱스 정보 저장
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i=0; i<n+2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        
        int idx = k+1;
        
        for(String c : cmd){
            if(c.startsWith("C")){
                trash.push(idx);
                
                // 중요 !! 연결리스트 활용하듯이, 서로 이어주기
                up[down[idx]] = up[idx];
                down[up[idx]] = down[idx];
                
                idx = n < down[idx] ? up[idx] : down[idx];
            }
            else if(c.startsWith("Z")){
                int restore = trash.pop();
                
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                
                for(int i=0; i<x; i++){
                    idx = s[0].equals("U") ? up[idx] : down[idx];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : trash){
            answer[i-1] = 'X';
        }
        
        return new String(answer);
    }
}