package beginnerCoder;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int[] arr = new int[10000];
		int cnt = 0;
		for(int i = 1 ; i*i<=N;i++) {
			if(N%i==0) {
				arr[cnt++] = i;
				if(N/i!=i) {
					arr[cnt++] = N/i;
				}
			}
		}
		int[] res = new int[cnt];
		for(int i = 0 ; i<res.length;i++) {
			res[i] = arr[i];
		}
		Arrays.sort(res);
		for(int n : res) {
			System.out.print(n+" ");
		}
	}

}
