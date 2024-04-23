import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> answerArr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        int count=0;
        while(!queue.isEmpty()){
            int item = queue.poll();
            count++;

            if(count == K){
                count = 0;
                answerArr.add(item);
                continue;
            }

            queue.add(item);
        }

        StringBuilder st = new StringBuilder();
        st.append("<");

        for(int i=0; i<answerArr.size(); i++){
            st.append(answerArr.get(i));
            if(i != answerArr.size()-1) st.append(", ");
        }
        st.append(">");
        System.out.println(st);

    }
}