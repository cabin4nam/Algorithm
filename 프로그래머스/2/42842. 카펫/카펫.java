class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 10 - (w*2) + 2*(h-2) = 2w + 2h - 4 = 2(w+h) - 4
        // w+h = 7
        // 7 = 3,4 2,5 1,6
        
        int sum = 0;
        // w+h가 될 수 있는 수
        sum = (brown+4) / 2;
        
        for(int i=2; i<=sum/2; i++){
            int h = i;
            int w = sum-i;
            
            if(w*h - brown == yellow){
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
}