class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int[] team = new int[n];
        for(int i=0; i<n; i++) team[i] = i;
        
        int teamCnt = 1;
        for(int stage=1; stage<=n; stage++){
            teamCnt *= 2;
            for(int j=0; j<n; j++){
                team[j] = j/teamCnt;
            }
            
//             for(int t : team) System.out.print(t + " ");
//             System.out.println();
            
            if(team[a-1] == team[b-1]){
                answer = stage;
                break;
            }
        }
        
        

        return answer;
    }
}