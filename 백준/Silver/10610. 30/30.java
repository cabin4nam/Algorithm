import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        long sum = 0;
        int[] numCount = new int[10];
        for(int i=0; i < str.length(); i++) {
            int tNum = Integer.parseInt(str.substring(i, i+1));
            numCount[tNum] += 1;
            sum+=tNum;
        }

        if(!str.contains("0") || sum%3 != 0){
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            while(numCount[i] > 0){
                sb.append(i);
                numCount[i] --;
            }
        }

        System.out.println(sb);
    }
}