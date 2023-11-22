import java.util.*;
import java.lang.Math;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 사각형으로 만들 수 있는 사각형 .. -> h 기준
        getSquare(yellow).forEach(s -> {
            if(getBorderLength(s, yellow/s) == brown) {
                answer[0] = yellow/s + 2;
                answer[1] = s + 2;
            }
        });
        
        return answer;
    }
    
    public ArrayList<Integer> getSquare(int size){
        ArrayList<Integer> squareSize = new ArrayList<Integer>();
        
        for(int i=1; i<=Math.sqrt(size); i++){
            if(size%i == 0) squareSize.add(i);
        }
        return squareSize;
    }
    
    public int getBorderLength(int h, int w){
        return ((h+w)*2) + 4;
    }
}