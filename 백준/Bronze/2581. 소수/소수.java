import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        // 소수의 합
        // 소수의 최솟값
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=m; i<=n; i++){
            if(isPrime(i)){
                sum+=i;

                if(min > i) min = i;
            }
        }

        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2) return true;

        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }

        return true;
    }

}
