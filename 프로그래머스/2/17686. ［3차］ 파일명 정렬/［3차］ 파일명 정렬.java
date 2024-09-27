import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        int head = 0;
        int num = 0;
        int tail = 0;
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // 각 파일명의 head, number, tail 도출
                int[] info1 = getInfo(s1);
                int[] info2 = getInfo(s2);
                
                // Head 에 따라 정렬
                String head1 = s1.substring(info1[0], info1[1]).toLowerCase();
                String head2 = s2.substring(info2[0], info2[1]).toLowerCase();
                if(head1.compareTo(head2) != 0){
                    return head1.compareTo(head2);
                }
                else { // Head가 똑같으면, Number로 비교
                    int num1 = Integer.parseInt(s1.substring(info1[1],info1[2]));
                    int num2 = Integer.parseInt(s2.substring(info2[1],info2[2]));
                    
                    if(num1 > num2){
                        return 1;
                    }
                    else if(num1 < num2){
                        return -1;
                    }

                }
                
                return 0;
            }
        });
        
        answer = new String[files.length];
        for(int i=0; i<files.length; i++){
            answer[i] = files[i];
        }
        
        
        return answer;
    }
    
    // 파일명을 분리하여 각 부분의 인덱스 위치를 반환하는 메소드
    private int[] getInfo(String s) {
        int start = 0; // Head의 시작 위치
        int numberStart = 0; // Number의 시작 위치
        int numberEnd = s.length(); // Number의 끝 위치

        // Head의 끝과 Number의 시작 찾기
        while (numberStart < s.length() && !Character.isDigit(s.charAt(numberStart))) {
            numberStart++;
        }

        // Number의 끝 찾기
        numberEnd = numberStart;
        while (numberEnd < s.length() && Character.isDigit(s.charAt(numberEnd))) {
            numberEnd++;
        }

        return new int[]{start, numberStart, numberEnd};
    }
}