import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] ops;
    static int numsCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numsCnt = Integer.parseInt(br.readLine());

        nums = new int[numsCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int c = 0; c<numsCnt; c++){
            nums[c] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4]; // +(0) -(1) *(2) /(3) 순

        st = new StringTokenizer(br.readLine());
        for(int o=0; o<4; o++){
            ops[o] = Integer.parseInt(st.nextToken());
        }

        if(nums.length <= 1){
            System.out.println(nums[0]);
            System.out.println(nums[0]);
            return;
        }

        calc(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calc(int num, int idx) {
        if (idx == numsCnt) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (ops[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                ops[i]--;
                switch (i) {
                    case 0:	calc(num + nums[idx], idx + 1);	break;
                    case 1:	calc(num - nums[idx], idx + 1);	break;
                    case 2:	calc(num * nums[idx], idx + 1);	break;
                    case 3:	calc(num / nums[idx], idx + 1);	break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                ops[i]++;
            }
        }
    }
}
