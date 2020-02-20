package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_DFS {
	static int[][] miro;
	static int startPointX;
	static int startPointY;
	static int endPointX;
	static int endPointY;
	static int X;
	static int Y;
	static int[][] visit;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		// X(가로), Y(세로) 크기
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		// 시작(x, y) 도착(x, y) 좌표
		st = new StringTokenizer(br.readLine().trim());
		startPointX = Integer.parseInt(st.nextToken());
		startPointY = Integer.parseInt(st.nextToken());
		endPointX = Integer.parseInt(st.nextToken());
		endPointY = Integer.parseInt(st.nextToken());

		// 미로 입력
		miro = new int[Y + 1][X + 1];
		visit = new int[Y + 1][X + 1];
		for (int i = 1; i <= Y; i++) {
			String s = br.readLine();
			for (int j = 1; j <= X; j++) {
				miro[i][j] = s.charAt(j - 1) - '0';
			}
		}

		// 도착점에서 bfs
		dfs(startPointY, startPointX);
		System.out.println(visit[endPointY][endPointX] - 1);

	}

	private static void dfs(int row, int col) {
		Stack<int[]> stack = new Stack<>();
		int time = 1;
		stack.push(new int[] { row, col, time });
		int[] cur;
		int nr, nc;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			row = cur[0];
			col = cur[1];
			time = cur[2];
		
			if (miro[row][col] == 0) {
				visit[row][col] = time++;
				for (int i = 0; i < 4; i++) {
					nr = row + dir[i][0];
					nc = col + dir[i][1];
					if (nr > 0 && nr <= X && nc > 0 && nc <= Y && miro[nr][nc] == 0 && visit[nr][nc] == 0) { // 경계검사
						stack.push(new int[] { nr, nc, time });
						if(row==endPointY && col==endPointX)break;
					}
				}
			}

		}

	}

}
