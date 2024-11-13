import java.util.ArrayList;
class Solution {
    public long solution(String expression) {
        String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, 
                         { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
        long answer = 0;
        
        // 연산자와 숫자를 구분해서 담아주기
        ArrayList<String> ex = new ArrayList<>();
        int start = 0;
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='*' || c=='-'){
                // 연산자 전의 숫자 더해주기
                ex.add(expression.substring(start, i));
                ex.add(expression.charAt(i)+"");
                start = i+1;
            }
        }
        ex.add(expression.substring(start)); // 마지막 숫자 추가
        
        // 우선순위에 따라 계산 결과 갱신
        for(int i=0; i<op.length; i++){
            ArrayList<String> subEx = new ArrayList<>(ex);
            for(int j=0; j<3; j++){
                for(int k=0; k<subEx.size(); k++){
                    if(op[i][j].equals(subEx.get(k))){
                        // 연산자 이전의 숫자를 연산자 다음의 숫자와의 계산 결과로 바꿔주기
                        subEx.set(k-1, calc(subEx.get(k-1), subEx.get(k), subEx.get(k+1)));
                        subEx.remove(k);
                        subEx.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(subEx.get(0))));
        }
        
        return answer;
    }
    
    private static String calc(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
 
        if (op.equals("+"))
            return n1 + n2 + "";
        else if (op.equals("-"))
            return n1 - n2 + "";
 
        return n1 * n2 + "";
    }
}