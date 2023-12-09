import java.util.*;
import java.lang.*; 

class Solution {
    int[][] min;
    int[][] max;
    public int solution(String arr[]) {
        int answer = -1;
        
        // 전체 식에서 피연산자(숫자)의 개수
        int size = arr.length/2+1; 
        
        // min[i][j] = i부터 j까지의 결과값의 최소
        min = new int[size][size];
        // max[i][j] = i부터 j까지의 결과값이 최대
        max = new int[size][size];
        
        // 전체 식의 피연산자들을 연산자와 합쳐서 (2-1 은 2와 -1로 저장) int 형으로 저장할 배열
        int[] list = new int[size];
        for(int i=0; i<arr.length; i+=2){
            int num = Integer.parseInt(arr[i]);
            // 0이면 +이든 -이든 상관 없음
            if(i==0){
                list[i/2] = num;
            }
            else {
                list[i/2] = arr[i-1].equals("+") ? num : -num;
            }
        }
        
        for(int i=size-1; i>=0; i--){
            for(int j = i; j<size; j++){
                // i와 j가 같은 경우는 숫자 하나인 경우 
                // -> 최소와 최대가 자기 자신일 수 밖에 없음
                if(i==j){
                    min[i][j] = list[i];
                    max[i][j] = list[i];
                }
                else {
                    // 비교할 수 있게 초기값 설정
                    min[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Integer.MIN_VALUE;
                    
                    for(int k=i; k<j; k++){
                        boolean value = k==i ? true : false;
                        
                        // 모든 경우의 수를 setValue 함수를 통해 검사
                        // (- 최솟값) + (- 최솟값)
                        // 최솟값 + 최댓값
                        // 최댓값 - 최솟값
                        // 최댓값 + 최댓값
                        setValue(min[i][k], min[k+1][j], i, j, value);
                        setValue(min[i][k], max[k+1][j], i, j, value);
                        setValue(max[i][k], min[k+1][j], i, j, value);
                        setValue(max[i][k], max[k+1][j], i, j, value);
                    }
                }
            }
        }
        
        return max[0][size-1];
    }
    
    // k 기준으로 나눈 두 파트 -> 앞쪽 : front, 뒤쪽 : back
    public void setValue(int a, int b, int x, int y, boolean value){
        // front가 숫자 하나 이고, 그 숫자가 - 값 일때
        // - 값인 한 숫자 -> 괄호를 통해 결과를 좌우할 수 있음
        // a-b의 경우 : -를 밖으로 빼고, 그 뒤를 괄호로 묶으면 더 작은 음수값을 얻을 수도 있음
        // a+b의 경우 : 괄호를 사용하지 않고 그대로 연산하는 경우
        if(value && a < 0){
            min[x][y] = Math.min(min[x][y], Math.min(a-b, a+b));
            max[x][y] = Math.max(max[x][y], Math.max(a-b, a+b));
        }
        // front가 숫자 하나가 아닌 식이거나
        // front가 숫자 하나이고, 그 숫자가 + 값 일때
        else {
            // 앞쪽 값과 뒤쪽 값을 더한 결과와 현재 min,max 값을 비교 -> 갱신
            min[x][y] = Math.min(min[x][y], a+b);
            max[x][y] = Math.max(max[x][y], a+b);
        }
    }
}