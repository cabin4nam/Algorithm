class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int n = s.length();

        // n개로 압축하는 경우들
        for (int unit = 1; unit <= n; unit++) {
            int length = 0;
            int idx = 0;

            while (idx < n) {
                String current = s.substring(idx, Math.min(idx + unit, n));
                int count = 1;
                
                // 다음 부분을 비교하여 연속된 부분의 개수 세기
                while (idx + unit < n && s.substring(idx, idx + unit).equals(s.substring(idx + unit, Math.min(idx + 2 * unit, n)))) {
                    count++;
                    idx += unit;
                }
                
                // 압축된 문자열 길이 추가
                if (count > 1) {
                    length += String.valueOf(count).length(); // 숫자의 길이 추가
                }
                length += current.length(); // 현재 부분 문자열의 길이 추가
                
                idx += unit; // 다음 부분으로 이동
            }
            
            // 가장 짧은 길이 업데이트
            answer = Math.min(answer, length);
        }

        return answer;
    }
}
