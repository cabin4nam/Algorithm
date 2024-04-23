import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] answerArr = new String[str.length()];

        for(int i=0; i<str.length(); i++){
            answerArr[i] = str.substring(i);
        }

        Arrays.sort(answerArr);

        for (String s : answerArr) {
            System.out.println(s);
        }

    }
}