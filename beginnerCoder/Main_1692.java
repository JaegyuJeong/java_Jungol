package beginnerCoder;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_1692 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c_3= a*(b%10);
		int c_4 = a*((b%100)/10);
		int c_5 = a*(b/100);
		System.out.println(c_3);
		System.out.println(c_4);
		System.out.println(c_5);
		System.out.println(c_3+c_4*10+c_5*100);
		
	}

}
