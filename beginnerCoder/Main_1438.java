package beginnerCoder;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main_1438 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int[][] big_paper = new int[100][100];
		int num = sc.nextInt();
		int cnt =0;
		for (int i = 0; i < num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

				for (int j = x; j < x + 10; j++) {
				for (int z = y; z < y + 10; z++) {
					big_paper[j][z] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(big_paper[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
