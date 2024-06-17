import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer>[] boardStack = new Stack[board.length];
        for(int r = board.length-1; r>=0; r--){
            for(int c= 0; c<board[r].length; c++){
                if(board[r][c] != 0){
                    if(boardStack[c] == null) boardStack[c] = new Stack<>();
                    
                    boardStack[c].push(board[r][c]);
                }
            }
        }
        
        Stack<Integer> basketStack = new Stack<>();
        for(int i=0; i<moves.length; i++){
            int line = moves[i];
            
            if(boardStack[line-1] == null || boardStack[line-1].empty()) continue;
            
            int doll = boardStack[line-1].pop();
            
            if(basketStack.empty()){
                basketStack.push(doll);
                continue;
            } 
            
            if(basketStack.peek() == doll){
                basketStack.pop();
                answer += 2;
            }
            
            else basketStack.push(doll);
        }
        
        return answer;
    }
}