import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // index(1) = 1
        // index(2) = index(1) + 2 = 3 까지
        // index(3) = index(2) + 3 = 6 까지

        // 구간합 구하기
        int[] sum = new int[1000];
        sum[0] = 1;

        int count=1;
        int numIndex = 2;
        while(count<1000){

            for(int i=0; i<numIndex; i++){
                if(count >= 1000) break;
                sum[count] = sum[count-1] + numIndex;
                count++;
            }
            numIndex ++;
        }

        if(a<2) System.out.println(sum[b-1]);
        else System.out.println(sum[b-1] - sum[a-2]);

    }

}
