import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static char[] nums = {'1','2','3'};
    private static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1,2,3을 조합해서 만들 수 있는 길이가 N인 수열 구하기
        n = Integer.parseInt(st.nextToken());

        makeNums(new StringBuilder(""));

        System.out.println(answer);
    }

    private static void makeNums(StringBuilder current) {
        if (current.length() == n) {
            answer = current.toString();
            return;
        }

        for (char num : nums) {
            current.append(num);
            if (checkNums(current)) {
                makeNums(current);
                if (!answer.isEmpty()) return; // 첫 번째 좋은 수열을 찾았으면 종료
            }
            current.deleteCharAt(current.length() - 1); // 마지막 문자 제거
        }
    }

    private static boolean checkNums(StringBuilder sequence) {
        int length = sequence.length();
        for (int len = 1; len <= length / 2; len++) {
            String first = sequence.substring(length - 2 * len, length - len);
            String second = sequence.substring(length - len);
            if (first.equals(second)) {
                return false; // 같은 부분 수열 발견
            }
        }
        return true; // 중복된 부분 수열 없음
    }
}