package beginnerCoder;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_1071 {

	public static void main(String[] args)throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i< n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int yak = 0 ;
		int bae = 0 ;
		
		for(int i = 0 ; i < n ; i++) {
			if(arr[i]<=m && m%arr[i]==0) {
				yak+=arr[i];
			}
			if(arr[i]>=m && arr[i]%m==0) {
				bae+=arr[i];
			}
		}
		
		System.out.println(yak);
		System.out.println(bae);
	}

}
