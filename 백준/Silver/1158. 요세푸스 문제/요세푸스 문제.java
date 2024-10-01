import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> answer = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=N; i++) nums.add(i-1, i);

        int removeIdx = 0;
        while(nums.size() > 0){
            removeIdx = (removeIdx+(K-1))%(nums.size());

            int n = nums.remove(removeIdx);

            answer.add(n);
        }

        System.out.print("<");
        for(int i=0; i<answer.size(); i++){
            if(i==answer.size()-1){
                System.out.print(answer.get(i));
            }
            else {
                System.out.print(answer.get(i) + ", ");
            }
        }
        System.out.print(">");
    }
}