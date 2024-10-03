import java.util.*;
class Solution {
    public static class Word{
        String word;
        int depth;
        
        public Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // target이 words에 없으면 0반환
        if(!Arrays.asList(words).contains(target)) return answer;
        
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word w = q.poll();
            
            if(w.word.equals(target)){
                return w.depth;
            }
            
            // begin의 각 자리의 글자를 바꾸는 경우
            for(String str : words){
                int diffCnt = 0;
                for(int i=0; i<w.word.length(); i++){
                    if(str.charAt(i) != w.word.charAt(i)) diffCnt ++;
                }
                
                if(diffCnt == 1){
                    q.offer(new Word(str, w.depth+1));
                }
            }
        }
        
        return 0;
    }
}