class Solution {
    private static String[] strs = {"A", "E", "I", "O", "U"};
    private static int answer;
    private static boolean hasFound = false;
    public int solution(String word) {
        answer = 0;
        
        makeWord(0, "", word);
        
        return answer;
    }
    
    private void makeWord(int depth, String result, String target){
        if(depth == 6 || hasFound) return;
        
        if(result.equals(target)){
            hasFound = true;
            return;
        }
        answer++;
        for(int i=0; i<strs.length; i++){
            makeWord(depth+1, result+strs[i], target);
        }
    }
}