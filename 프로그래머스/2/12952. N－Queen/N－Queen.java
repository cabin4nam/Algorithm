class Solution {
    private static int answer = 0;
    private static int[] arr;
    public int solution(int n) {
        
        arr = new int[n];
        
        dfs(n, 0);
        
        return answer;
    }
    
    public void dfs(int n, int depth){
        if(depth == n){
            answer++;
			return;
        }
        
        for(int i=0; i<n; i++){
            arr[depth] = i;
            if(possible(depth)) {
				dfs(n, depth+1);
			}
        }
    }
    
    public boolean possible(int col){
        for(int i = 0 ; i < col ; i++) {
            //열에 일치하는게 있는지 판별
            if(arr[i]==arr[col]) {
                return false;
            }
            //대각선에 일치하는게 있는지 판별
            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }
			
		}
		
		return true;
    }
}