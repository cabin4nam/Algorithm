class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int begin = 1;
        for(int i=0; i<stations.length; i++){
            if(begin < stations[i]-w){
                answer += searchCount(begin, stations[i]-w-1, w);
            }
            begin = stations[i]+w+1;
        }
        
        if(begin <= n){
            answer += searchCount(begin, n, w);
        }

        return answer;
    }
    
    private static int searchCount(int begin, int end, int w){
        int count = 0;
        count = (end-begin+1)/(2*w+1);
        if((end-begin+1)%(2*w+1)!=0) count ++;
        
        return count;
    }
}