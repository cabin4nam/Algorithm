class Solution {
    private static String[] chars = {"A", "E", "I", "O", "U"};
    private static int answer;
    private static boolean isMatched = false;
    public int solution(String word) {
        answer = 0;
        
        makeWord(word, "");
        
        return answer;
    }
    
    public void makeWord(String target, String now){
        if(isMatched) return;
        if(now.length() > 5) return;
        if(now.equals(target)){
            isMatched = true;
            return;
        }
        
        answer ++;
        
        for(int i=0; i<chars.length; i++){
            makeWord(target, now+chars[i]);
        }
        
    }
}