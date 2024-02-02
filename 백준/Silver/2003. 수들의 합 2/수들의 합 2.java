import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int answer = 0;

       int[] nums = new int[N]; // 입력받을 N개의 숫자
       int[] sums = new int[N]; // 구간합을 저장할 변수
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<N; i++){
           nums[i] = Integer.parseInt(st.nextToken());

           if(i==0) sums[i] = nums[i];
           else sums[i] = sums[i-1] + nums[i];
       }

       // 포인터 역할할 변수 2개
       int start=0, end=0;
       while(end < N){
           if(start == end){
               if(nums[start] < M) end++;
               else if(nums[start] > M){
                   start ++;
                   end ++;
               }
               else {
                   start ++;
                   end++;
                   answer ++;
               }
           }
           else {
               int sum = 0;
               if(start == 0) sum = sums[end];
               else sum = sums[end] - sums[start-1];

               if(sum < M) end++;
               else if(sum > M)
                   start++;
               else{
                   start++;
                   end++;
                   answer ++;
               }

           }
       }

        System.out.println(answer);
    }

}