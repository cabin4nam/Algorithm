import java.util.Arrays;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] skills = skill.split("");
        
        for(String sk : skill_trees){
            boolean isRight = true;
            int needIdx = 0;
            for(int i=0; i<sk.length(); i++){
                String s = String.valueOf(sk.charAt(i));
                if(Arrays.asList(skills).indexOf(s) != -1){
                    // 현재 스킬 인덱스의 선행스킬 (직전 인덱스의 스킬)이 앞에 있어야 함.
                    if(Arrays.asList(skills).indexOf(s) > needIdx){
                        isRight = false;
                        break;
                    }
                    
                    needIdx ++;
                }
            }
            
            if(isRight) answer++;
        }
        
        return answer;
    }
}