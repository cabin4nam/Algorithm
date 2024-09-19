import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static long[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        p = new long[101];
        Arrays.fill(p, -1);
        p[0] = 0; p[1] = 1; p[2] = 1; p[3] = 1;

        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(lengthOfRect(n));
        }

    }

    private static long lengthOfRect(int n){
        if(p[n] == -1) {
            p[n] = lengthOfRect(n-3) + lengthOfRect(n-2);
        }
        return p[n];
    }
}