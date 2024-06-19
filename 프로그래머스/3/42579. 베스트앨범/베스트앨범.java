import java.util.*;
import java.util.stream.*;

class Solution {
    class Song{
        int idx;
        int play;
        
        public Song(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, ArrayList<Song>> bestSongs = new HashMap<>();
        HashMap<String, Integer> sumOfPlay = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(!bestSongs.containsKey(genres[i])) bestSongs.put(genres[i], new ArrayList<>());
            bestSongs.get(genres[i]).add(new Song(i, plays[i]));
            sumOfPlay.put(genres[i], sumOfPlay.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 별 재생 횟수 기준 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = sumOfPlay.entrySet().stream()
            .sorted((g1, g2) -> Integer.compare(g2.getValue(), g1.getValue()));
        
        // 장르 내 곡들의 재생 횟수 내림차순 정렬
        sortedGenre.forEach(entry -> {
            List<Song> sortedSongs = bestSongs.get(entry.getKey()).stream()
                .sorted((s1, s2) -> Integer.compare(s2.play, s1.play))
                .collect(Collectors.toList());
            
            for(int i=0; i<sortedSongs.size(); i++){
                if(i==2) break;
                
                answer.add(sortedSongs.get(i).idx);
            }
        });
        
        return answer;
    }
}