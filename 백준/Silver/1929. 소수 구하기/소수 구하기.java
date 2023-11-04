import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        for(int i=M; i<=N; i++){
            if(isPrime(i) == true) System.out.println(i);
        }     
    }

    public static boolean isPrime(int n){
        int count=0;
        if(n==1) return false;
        for(int i=2 ; i*i<=n; i++) {
            if(n%i ==0) {
              return false; //n이 i의 배수면 소수가 아니므로 false
            }
        }
         return true;
    }

}