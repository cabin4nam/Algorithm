class Solution {
    private static int answer = Integer.MAX_VALUE;
    private static int[] mineralsArr;
    private static int[][] power;
    
    public int solution(int[] picks, String[] minerals) {
        power = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        // minerals 배열을 숫자로 변환하여 관리
        mineralsArr = new int[minerals.length];
        for (int i = 0; i < minerals.length; i++) {
            int mineral = minerals[i].equals("diamond") ? 0 : minerals[i].equals("iron") ? 1 : 2;
            mineralsArr[i] = mineral;
        }
        
        // 각 곡괭이 사용 시작
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;
            
            mine(picks.clone(), i, 0, 0);  // 배열 복사 후 재귀 호출
        }
        
        return answer;
    }
    
    private void mine(int[] pickCnt, int present, int usedPickCnt, int sum) {
        // 광물 최대 5개 캐기
        for (int i = 5 * usedPickCnt; i < 5 * (usedPickCnt + 1); i++) {
            if (i >= mineralsArr.length) {  // 더 이상 캘 광물이 없으면 종료
                answer = Math.min(answer, sum);
                return;
            }
            sum += power[present][mineralsArr[i]];
        }
        
        pickCnt[present]--;  // 현재 곡괭이 사용
        
        // 종료 조건: 곡괭이가 모두 소진되었거나, 모든 광물이 캐졌을 경우
        if (pickCnt[0] == 0 && pickCnt[1] == 0 && pickCnt[2] == 0) {
            answer = Math.min(answer, sum);
            return;
        }
        
        // 다음 곡괭이 선택
        for (int i = 0; i < pickCnt.length; i++) {
            if (pickCnt[i] > 0) {  // 남은 곡괭이가 있을 때만 호출
                mine(pickCnt.clone(), i, usedPickCnt + 1, sum);  // 배열 복사 후 재귀 호출
            }
        }
    }
}