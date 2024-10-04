import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Doc{
        int num;
        int level;
        public Doc(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<Doc> docs = new LinkedList<>();
            for(int i=0; i<N; i++){
                int lv = Integer.parseInt(st.nextToken());
                docs.add(new Doc(i, lv));
            }

            int count = 0;
            while(!docs.isEmpty()){
                Doc doc = docs.poll();

                boolean isMax = true;
                for(int i=0; i<docs.size(); i++){
                    if(docs.get(i).level > doc.level){
                        isMax = false;
                    }
                }

                if(isMax){
                    count ++;
                    if(doc.num == K){
                        System.out.println(count);
                        break;
                    }
                }
                else {
                    docs.add(doc);
                }

            }
        }

    }

}