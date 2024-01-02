import java.util.Scanner;

public class Main {
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long S = sc.nextInt();
		map = new int[N];

		for(int i=0; i<N; i++){
			map[i] = sc.nextInt();
		}
		
		int ans = 987654321;
		int left = 0;
		int right = 0;
		int sum = 0;
		
		while(left < N) {
			if(sum >= S) { //합이 목표치보다 크면 왼쪽 하나 빼주기
				ans = Integer.min(ans,(right-left));
				sum -= map[left++];
			}else if(sum < S && right < N) { //합이 목표치보다 작으면 오른쪽 추가
				sum += map[right++];
			}else if(sum < S && right >= N){ //끝까지 도달했는데 값 안나오면 X
				break;
			}
		}
		System.out.println(ans == 987654321 ? 0 : ans);
	}
}