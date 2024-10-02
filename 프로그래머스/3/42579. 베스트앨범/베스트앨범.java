import java.util.*;
class Solution {
    private static class Song{
        int id;
        int play;
        
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genreCount = new HashMap<>(); // 장르별 총 재생 횟수
        Map<String, List<Song>> songCount = new HashMap<>(); // 장르 별 곡의 재생
        
        for(int i=0; i<plays.length; i++){
            String genre = genres[i];
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + plays[i]);
            
            if(!songCount.containsKey(genre)) songCount.put(genre, new ArrayList<>());
            songCount.get(genre).add(new Song(i, plays[i]));
        }
        
        // 정렬
        List<String> genreKeySet = new ArrayList<>(genreCount.keySet());
        Collections.sort(genreKeySet, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return genreCount.get(s2) - genreCount.get(s1);
            }
        });
        
        for(String key : genreKeySet){
            List<Song> songs = songCount.get(key);
            
            Collections.sort(songs, new Comparator<Song>(){
               @Override
                public int compare(Song s1, Song s2){
                    if(s1.play < s2.play) return 1;
                    else if(s1.play > s2.play) return -1;
                    else {
                        return s1.id - s2.id;
                    }
                }
            });
        }
        
        for(String key : genreKeySet){
            List<Song> songs = songCount.get(key);
            
            for(int i=0; i<songs.size(); i++){
                if(i>1) break;
                answer.add(songs.get(i).id);
            }
        }
        
        
        
        return answer;
    }
}