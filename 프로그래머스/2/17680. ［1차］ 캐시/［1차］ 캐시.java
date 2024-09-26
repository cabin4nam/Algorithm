import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        List<String> cache = new ArrayList<>();
        for(String c : cities){
            String city = c.toLowerCase();
            if(cache.contains(city)){
                answer += 1;
                
                cache.remove(cache.indexOf(city));
                cache.add(city);
            }
            else {
                answer += 5;
                
                if(cache.size() == cacheSize) cache.remove(0);
                cache.add(city);
            }
        }
        
        
        return answer;
    }
}