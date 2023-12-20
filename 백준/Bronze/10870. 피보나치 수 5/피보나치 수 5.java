import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

}
