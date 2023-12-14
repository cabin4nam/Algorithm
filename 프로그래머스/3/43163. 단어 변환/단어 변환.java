import java.util.*;
class Solution {
    static int[] count;
    static int min = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        count = new int[words.length];
        visited = new boolean[words.length];
        
        bfs(begin, target, words);
        
        return min;
    }
    
    static void bfs(String begin, String target, String[] words){
         Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<words.length; i++){
            int diffCnt = 0;

            for(int j = 0; j<words[i].length(); j++){
                if(!words[i].substring(j,j+1).equals(begin.substring(j,j+1))) diffCnt ++;
            }

            if(diffCnt == 1 && !visited[i]) {
                q.add(i);
                visited[i] = true;
                count[i] = 1;
            }
        }
       
        
        while(!q.isEmpty()){
            int currentIndex = q.poll();
              
            if(words[currentIndex].equals(target)){
                min = count[currentIndex];
                return;
            }

            for(int i=0; i<words.length; i++){
                int diffCnt = 0;

                for(int j = 0; j<words[i].length(); j++){
                    if(!words[i].substring(j,j+1).equals(words[currentIndex].substring(j,j+1))) diffCnt ++;
                }

                if(diffCnt == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count[i] = count[currentIndex]+1;
                }
            }
        }
        
    }
}