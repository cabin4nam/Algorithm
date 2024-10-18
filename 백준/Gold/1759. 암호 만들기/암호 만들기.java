import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
서로 다른 L개의 알파벳 소문자
최소 한개의 모음, 최소 두개의 자음

암호에서 알파벳 오름차순 배열

C개의 문자들을 가지고 만들 수 있는 암호 모두 출력
 */
public class Main {
    private static int L;
    private static int C;
    private static String[] chars;
    private static StringBuilder sb = new StringBuilder();
    private static List<Character> 모음 = Arrays.asList('a', 'e', 'i', 'o', 'u');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            chars[i] = st.nextToken();
        }
        Arrays.sort(chars); // 알파벳 순으로 정렬된 암호를 구하기 위해서

        for(int i=0; i<C; i++){
            findCode(i, 1, chars[i]);
        }

        System.out.println(sb);
        
    }
    private static void findCode(int start, int depth, String result){
        if(depth == L){
            // 최소 한 개의 모음과 최소 두 개의 자음을 포함하였는가?
            int cnt1 = 0, cnt2 = 0; // 모음 개수, 자음 개수
            for(int i=0; i<result.length(); i++){
                if(모음.contains(result.charAt(i))) cnt1 ++;
                else cnt2++;
            }

            if(cnt1 >= 1 && cnt2 >= 2)
                sb.append(result).append("\n");
            return;
        }

        for(int i=start+1; i<C; i++){
            findCode(i, depth+1, result + chars[i]);
        }
    }
}