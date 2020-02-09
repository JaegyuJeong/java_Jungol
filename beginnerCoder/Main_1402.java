package beginnerCoder;

import java.util.Scanner;

public class Main_1402 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] yak = new int[N+1];
		for(int i = 1 ; i<=N ; i++) {
			if(N%i == 0 ) {
				yak[i] = i;
			}
		}
		
		int cnt = 0;
		for(int i = 1 ; i<=N ; i++) {
			if(yak[i]!=0) {
				cnt++;
				if(cnt == K) {
					System.out.println(yak[i]);
				}
			}
		}
		if(cnt<K) {
			System.out.println(0);
		}
	}

}
