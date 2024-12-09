import java.util.*;

class Solution {
    private int diceCnt;
    private int maxWin = Integer.MIN_VALUE;
    private int[] answer;

    public int[] solution(int[][] dice) {
        diceCnt = dice.length;
        answer = new int[diceCnt / 2];

        // 모든 주사위를 골라 A팀/B팀 조합을 효율적으로 계산
        solve(dice, 0, 0, new ArrayList<>(), new boolean[diceCnt]);

        return answer;
    }

    private void solve(int[][] dice, int index, int depth, List<Integer> selectedDice, boolean[] visited) {
        // 종료 조건: n/2개 주사위 선택 완료
        if (depth == diceCnt / 2) {
            List<Integer> otherDice = new ArrayList<>();
            for (int i = 0; i < diceCnt; i++) {
                if (!visited[i]) {
                    otherDice.add(i);
                }
            }

            // A팀과 B팀의 승리 횟수 계산
            int winCount = calculateWin(dice, selectedDice, otherDice);
            if (winCount > maxWin) {
                maxWin = winCount;
                for (int i = 0; i < selectedDice.size(); i++) {
                    answer[i] = selectedDice.get(i) + 1;
                }
            }
            return;
        }

        for (int i = index; i < diceCnt; i++) {
            visited[i] = true;
            selectedDice.add(i);
            solve(dice, i + 1, depth + 1, selectedDice, visited);
            selectedDice.remove(selectedDice.size() - 1);
            visited[i] = false;
        }
    }

    private int calculateWin(int[][] dice, List<Integer> selectedDice, List<Integer> otherDice) {
        List<Integer> scoresA = getPossibleSums(dice, selectedDice);
        List<Integer> scoresB = getPossibleSums(dice, otherDice);

        // B팀 점수 리스트 정렬 (이분탐색 사용)
        Collections.sort(scoresB);

        int winCount = 0;
        for (int scoreA : scoresA) {
            int idx = lowerBound(scoresB, scoreA);
            winCount += idx; // idx : B팀 점수 중 A팀이 이기는 범위
        }

        return winCount;
    }

    private List<Integer> getPossibleSums(int[][] dice, List<Integer> teamDice) {
        List<Integer> result = new ArrayList<>();
        computeCombinations(dice, teamDice, 0, 0, result);
        return result;
    }

    private void computeCombinations(int[][] dice, List<Integer> teamDice, int depth, int currentSum, List<Integer> sums) {
        if (depth == teamDice.size()) {
            sums.add(currentSum);
            return;
        }

        int diceIndex = teamDice.get(depth);
        for (int face : dice[diceIndex]) {
            computeCombinations(dice, teamDice, depth + 1, currentSum + face, sums);
        }
    }

    private int lowerBound(List<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
