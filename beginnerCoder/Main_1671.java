package beginnerCoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1671 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int[][] big_paper = new int[100+1][100+1];
		int[][] pos = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int num = sc.nextInt();
		int cnt = 0;
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
				if (big_paper[i][j] == 1) {
					for(int z = 0 ; z<4; z++) {
						if(big_paper[i+pos[z][0]][j+pos[z][1]]==0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
