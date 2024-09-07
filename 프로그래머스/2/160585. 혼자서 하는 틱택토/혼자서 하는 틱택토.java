// 1. X가 O보다 많을 경우
// 2. O로 승리했는데, X가 O와 같거나 많을 경우
// 3. X로 승리했는데, O가 X보다 많을 경우

import java.util.*;
class Solution {
    static class Point{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private static ArrayList<Point> firstAttack; // 선공이 한 표시
    private static ArrayList<Point> secondAttack; // 후공이 한 표시
    private static boolean[][] visited;
    
    public int solution(String[] board) {
        int answer = -1;
        
        firstAttack = new ArrayList<>(); // 선공이 한 표시
        secondAttack = new ArrayList<>(); // 후공이 한 표시
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j)=='O') firstAttack.add(new Point(i,j));
                else if(board[i].charAt(j)=='X') secondAttack.add(new Point(i,j));
            }
        }
        
        //'X'가 'O'보다 많으면 규칙 위반
        if(firstAttack.size() < secondAttack.size()){
            return 0;
        }
        
        //'O'가 'X'보다 2개이상 많으면 규칙 위반
        if (firstAttack.size() > secondAttack.size() + 1) {
            return 0;
        }
        
        // 선공이 승리했을 때 X가 O의 개수와 같으면 규칙 위반
        if (isWin(board, 'O')) {
            if (firstAttack.size() == secondAttack.size()) {
                return 0;
            }
        }
        
        // 후공이 승리했을 때, O가 X보다 1개 많으면 규칙 위반
        if (isWin(board, 'X')) {
            if (firstAttack.size() >= secondAttack.size()+1) {
                return 0;
            }
        }
        
        
        return 1;
    }
    
    private static boolean isWin(String[] board, char ch) {
        //가로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch
                    && board[i].charAt(1) == ch
                    && board[i].charAt(2) == ch) {
                return true;
            }
        }
        //세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch
                    && board[1].charAt(i) == ch
                    && board[2].charAt(i) == ch) {
                return true;
            }
        }
        //대각선 검사
        if (board[0].charAt(0) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}