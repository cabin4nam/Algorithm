class Solution {
    private static int answer;
    private static String[] alpha = {"A", "E", "I", "O", "U"};
    private static boolean hasFound = false;
    public int solution(String word) {
        answer = 0;
        
        for(String a : alpha){
            findWord(a, word);
        }
        
        return answer;
    }
    
    private static void findWord(String word, String target){
        if(word.length() > 5 || hasFound) return;
    
        answer++;
        if(word.equals(target)){
            hasFound = true;
            return;
        }
        
        for(String s : alpha){
            findWord(word+s, target);
        }
    }
}