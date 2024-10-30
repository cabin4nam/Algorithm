// 참고 :  https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
class Solution {
	public String solution(String number, int k) {
		String answer = "";
        
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		
		// 앞에서 부터 (전체길이 - k) 수 중 가장 큰 수 선택
		// 선택한 수 다음 인덱스 부터 탐색 범위를 한칸씩 늘려가며 반복 탐색
		for(int i = 0; i < number.length() - k; i++) {
			char max = 0;
			for(int j = idx; j <= i + k; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			sb.append(max);
		}
        
        return sb.toString();
    }
}