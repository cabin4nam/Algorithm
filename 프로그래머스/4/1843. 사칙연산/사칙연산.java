class Solution {
    public int solution(String arr[]) {
        int numberCnt = arr.length/2 + 1;
        int opCnt = arr.length/2;
        
        int[] numbers = new int[numberCnt];
        String[] ops = new String[opCnt];
        
        int idxNum = 0;
        int idxOp = 0;
        for(String a : arr){
            if(a.equals("+") || a.equals("-")) ops[idxOp++] = a; 
            else numbers[idxNum++] = Integer.parseInt(a);
        }
        
        int[][] maxDP = new int[numberCnt][numberCnt];
        int[][] minDP = new int[numberCnt][numberCnt];
    
        for(int i=0; i<numberCnt; i++) maxDP[i][i] = minDP[i][i] = numbers[i];
        
        for(int len = 1; len<numberCnt; len++){
            for(int start = 0; start<numberCnt; start++){
                if (start + len >= numberCnt) break;
                
                int end = start+len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                for(int i=start; i<end; i++){
                    // 덧셈일 떄
                    if(ops[i].equals("+")){
                        max = Math.max(max, maxDP[start][i] + maxDP[i+1][end]);
                        min = Math.min(min, minDP[start][i] + minDP[i+1][end]);
                    }
                    
                    // 뺄셈일 때
                    else{
                        max = Math.max(max, maxDP[start][i] - minDP[i+1][end]);
                        min = Math.min(min, minDP[start][i] - maxDP[i+1][end]);
                    }
                }
                
                maxDP[start][end] = max;
                minDP[start][end] = min;
                
            }
        }
        
        return maxDP[0][numberCnt-1];
    
    }
}