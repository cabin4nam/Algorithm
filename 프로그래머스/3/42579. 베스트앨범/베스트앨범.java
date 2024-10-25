import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
class Solution {
    private static class Song{
        int id;
        int play;
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, ArrayList<Song>> map = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(map.get(genres[i]) == null) map.put(genres[i], new ArrayList<>());
            
            map.get(genres[i]).add(new Song(i, plays[i]));
            sum.put(genres[i], sum.getOrDefault(genres[i],0) + plays[i]);
        }
        
        // genre를 오름차순 정렬 (sum)
        ArrayList<String> sumKeySet = new ArrayList<>(sum.keySet());
        Collections.sort(sumKeySet, (s1, s2) -> sum.get(s2) - sum.get(s1));

        // genre별로 노래 오름차순 정렬 (같으면 고유 번호가 낮은 것부터) (map)
        for (String key : sumKeySet) {
            Collections.sort(map.get(key), (s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id; // play 횟수가 같으면 id 오름차순 정렬
                }
                return s2.play - s1.play; // play 횟수로 오름차순 정렬
            });

            for (int i = 0; i < map.get(key).size(); i++) {
                if (i >= 2) break;

                answer.add(map.get(key).get(i).id);
            }
        }

        
        
        return answer;
    }
}