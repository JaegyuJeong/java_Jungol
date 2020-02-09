package beginnerCoder;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		int gcd = 0; 
		int lcm = 0;
		
		for(int i = 0 ; i< N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		gcd = arr[N-1];
		lcm = arr[N-1];
		
		for(int i = N-2 ; i>=0; --i) {
			int x,y;
			if(gcd>arr[i]) {
				x = gcd;
				y = arr[i];
			}else {
				y = gcd;
				x = arr[i];
			}
			gcd = getGcd(x,y);
			
			if(lcm > arr[i]) {
				x = lcm;
				y = arr[i];
			}else {
				y = lcm;
				x = arr[i];
			}
			lcm = (x*y)/getGcd(x,y);
		}
		System.out.println(gcd+" "+lcm);
		

	}

	private static int getGcd(int x, int y) {
		if(x%y ==0) return y;
		return getGcd(y, x%y);
	}

}
