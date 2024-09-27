import java.util.*;
public class Solution {
    private String[][] relation;
    private final List<String> indexList = new LinkedList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        String[] arr = new String[relation[0].length];
        for(int i=0; i<relation[0].length; i++)
            arr[i] = Integer.toString(i);

        // 요소가 1개인 부분집합 ~ 요소가 attribute의 개수인 부분 집합
        for (int i = 1; i <= relation[0].length; i++)
            combination(arr, new boolean[relation[0].length], 0, i);

        return indexList.size();
    }

    public void combination(String[] arr, boolean[] check, int index, int r) {
        // 부분집합에 포함하기로 한 개수가 다 채워지면 -> 후보키 자격 검사
        if (r == 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                // 현재 선택된 부분집합
                if (check[i])
                    result.append(arr[i]);
            }
            
            System.out.println("result : " + result);

            for (String sub : indexList) {
                System.out.println("sub..? " + sub);
                int count = 0;
                for (int i = 0; i < sub.split("").length; i++) {
                    if(result.toString().contains(String.valueOf(sub.charAt(i))))
                        count++;
                }

                // result가 완전히 sub의 부분집합일 경우 -> 최소성 만족 X
                if (sub.length() == count)
                    return;
            }

            // 후보키 검사 통과 시, 후보키 리스트에 저장
            if (dupleCheck(result.toString()))
                indexList.add(result.toString());
        } else {
            for (int i = index; i < arr.length; i++) {
                // 백트래킹
                check[i] = true;
                combination(arr, check, i + 1, r - 1);
                check[i] = false;
            }
        }
    }

    public boolean dupleCheck(String index) {
        Set<String> set = new HashSet<>();

        for (String[] strings : relation) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < index.split("").length; j++) {
                builder.append(strings[Integer.parseInt(String.valueOf(index.charAt(j)))]);
                builder.append("/");
            }

            if (set.contains(builder.toString()))
                return false;
            else
                set.add(builder.toString());
        }

        return true;
    }
}