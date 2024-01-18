import java.util.*;
import java.io.*;

public class Main {
    static class Num{
        int isPositive;
        int num;

        public Num(int isPositive, int num){
            this.isPositive = isPositive;
            this.num = num;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                if(o1.num > o2.num) return 1;
                else if(o1.num < o2.num) return -1;
                else return o1.isPositive > o2.isPositive ? 1 : -1;
            }
        });

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else{
                    Num thisNumber = pq.poll();
                    System.out.println(thisNumber.num * thisNumber.isPositive);
                }
            }
            else {
                if (n > 0) pq.add(new Num(1, n));
                else pq.add(new Num(-1, n * (-1)));
            }
        }
    }
}