import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            nums[i] = num;
        }

        // set을 오름차순 정렬
        List<Integer> tempSet = new ArrayList<>(set);
        Collections.sort(tempSet);

        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for(int i : tempSet){
            if(!map.containsKey(i)){
                map.put(i, index);
                index ++;
            }
        }

        for(int num : nums){
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);

    }
}