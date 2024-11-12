class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='P' || c=='p') countP ++;
            else if(c=='Y' || c=='y') countY ++;
        }
        
        if(countP == 0 && countY ==0) return true;

        if(countP == countY) return true;
        else return false;
    }
}