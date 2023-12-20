import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int presentCnt = 0;
        int max=0;
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            presentCnt -= out;
            presentCnt += in;

            if(presentCnt > max) max = presentCnt;

        }

        System.out.println(max);
    }

}
