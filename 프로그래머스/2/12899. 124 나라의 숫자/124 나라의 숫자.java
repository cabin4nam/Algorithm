class Solution {
    public String solution(int n) {

        String result = "";
        String[] str124 = {"1", "2", "4"};

        // 124 나라의 숫자 체계는 3의 배수마다 자릿수가 바뀌게 되니
        // 편리하게 n에 1을 빼주어 3진법으로 구한다.(0을 활용하기 위함)
        while (n > 0){

            n--;

            result = str124[n%3] + result;

            n = n / 3;
        }

        return result;
    }
}