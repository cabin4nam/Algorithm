class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int unit = 2*w + 1;
        for(int i=0; i<=stations.length; i++){
            int start = 1;
            int end = 1;
            
            if(i==stations.length){
                start = stations[i-1]+w+1;
                end = n;
            }
            
            else {
                if(i > 0) start = stations[i-1] + w +1;
                
                end = stations[i]-w-1;
            }
            
            
            int gap = end-start+1;
            answer += gap/unit;
            if(gap%unit > 0) answer ++;
        }

        return answer;
    }
}