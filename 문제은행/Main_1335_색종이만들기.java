package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기 {
	static int b_cnt;
	static int w_cnt;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		int[][] c_paper = new int[N][N];
		b_cnt = 0;
		w_cnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				c_paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut_paper(c_paper, N, 0, 0);
		System.out.println(w_cnt);
		System.out.println(b_cnt);

	}

	private static void cut_paper(int[][] c_paper, int n, int x, int y) {
		int start_x = x, start_y = y;
		boolean flag = true;
		int tmp = c_paper[start_x][start_y];
		go: for (int i = start_x; i < start_x + n; i++) {
			for (int j = start_y; j < start_y + n; j++) {
				if (c_paper[i][j] != tmp) {
					flag = false;
					break go;
				}
			}
		}

		if (!flag) {
			int mid = n / 2;
			cut_paper(c_paper, mid, start_x, start_y);
			cut_paper(c_paper, mid, start_x, start_y + mid);
			cut_paper(c_paper, mid, start_x + mid, start_y);
			cut_paper(c_paper, mid, start_x + mid, start_y + mid);
		} else {
			if (tmp == 1) {
				b_cnt++;
			} else {
				w_cnt++;
			}
		}

	}

}
