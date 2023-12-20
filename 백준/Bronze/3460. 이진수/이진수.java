import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t<T; t++){
            int[] bits = new int[20];
            int n = sc.nextInt();

            int index = 19;
            while(index >= 0){
                bits[index] = 0;
                double num = Math.pow(2, index);
                if(num <= n){
                    bits[index] = 1;

                    n -= num;
                }
                index --;
            }

            for(int i=0; i<bits.length; i++){
                if(bits[i] == 1) System.out.print(i + " ");
            }
        }
    }

}
