import java.util.ArrayList;
class Solution {
    private static ArrayList<int[]> answer;
    public ArrayList<int[]> solution(int n) {
        answer = new ArrayList<>();
        
        hanoi(n, 1,3,2);
        
        return answer;
    }
    
    private static void hanoi(int n, int start,int end, int mid){
        if(n<1) return;
            
        hanoi(n-1, start, mid, end);
        answer.add(new int[]{start, end});
        hanoi(n-1, mid, end, start);
    }
}