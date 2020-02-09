package beginnerCoder;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1430 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b= sc.nextInt();
		int c = sc.nextInt();
		int[] k_num = new int[10];
		
		int res = a*b*c;
		int k =0;
		while(res>0) {
			k = res%10;
			k_num[k]++;
			res/=10;
		}
		for(int n : k_num) {
			System.out.println(n);
		}


	}

}
