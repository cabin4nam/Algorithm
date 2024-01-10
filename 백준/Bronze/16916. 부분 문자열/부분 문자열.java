import java.io.*;

public class Main {
    static int[] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 문자열
        String fullStr = br.readLine();
        // 전체 문자열에서 찾을 부분 문자열
        String matchStr = br.readLine();

        // 접두/접미 비교를 위한 배열
        pattern = new int[fullStr.length()];
        makeTable(fullStr);

        System.out.println(findString(fullStr, matchStr));
    }

    private static int findString(String full, String match) {
        int strIdx = 0;
        int matchIdx = 0;

        while (strIdx < full.length() && matchIdx < match.length()) {
            if (full.charAt(strIdx) == match.charAt(matchIdx)) {
                strIdx++;
                matchIdx++;
            } else {
                if (matchIdx != 0) {
                    matchIdx = pattern[matchIdx - 1];
                } else {
                    strIdx++;
                }
            }
        }

        return (matchIdx == match.length()) ? 1 : 0;
    }

    private static void makeTable(String str) {
        int n = str.length();

        int idx = 0;
        for (int i = 1; i < n; i++) {
            while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = pattern[idx - 1];
            }
            if (str.charAt(i) == str.charAt(idx)) {
                idx++;
                pattern[i] = idx;
            }
        }
    }
}
