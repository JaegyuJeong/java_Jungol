package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬_정재규 {

	static int row;
	static int col;
	static char[][] map;
	static boolean[][] visit;
	static int[][] tot_dis;
	static int distance;
	static int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		visit = new boolean[row][col];
		tot_dis = new int[row][col];
		int max = Integer.MIN_VALUE;

		//입력 받은 char를 map배열에 담아준다.
		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// map배열을 탐색하다가 'L'을 만나면 bfs를 진행하여 끝까지 도달하는 거리를 구한다.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'L') {
					distance = 0;
					bfs(i, j,distance);//현재 좌표(i,j)와 초기화된 distance변수를 넘겨준다.
				}
			}
		}
		
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				System.out.print(tot_dis[i][j]+" ");
//			}
//			System.out.println();
//		}

		//각 위치에 담긴 거리 값을 비교하여 가장 거리가 먼 길이를 선택한다.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (tot_dis[i][j] > max) {
					max = tot_dis[i][j];
				}
			}
		}
		//출력
		System.out.println(max);
	}

	private static void bfs(int rinput, int cinput, int dis) {
		LinkedList<int[]> queue = new LinkedList<>(); 
		queue.offer(new int[] { rinput, cinput, dis++ }); //입력 받은 좌표(r,c, 거리) 값을 담아준다.
		visit[rinput][cinput] = true; //해당하는 위치를 방문표시로 바꿔준다.
		int[] cur;
		int r, c, t, nr, nc;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0];
			c = cur[1];
			t = cur[2];
			for (int i = 0; i < 4; i++) {
				nr = r + pos[i][0];
				nc = c + pos[i][1];
				if (nr >= 0 && nr < row && nc >= 0 && nc < col && map[nr][nc] == 'L' && !visit[nr][nc]) {
					queue.offer(new int[] { nr, nc, t+1 });
					visit[nr][nc] = true;
				}
			}
			tot_dis[rinput][cinput] = t;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visit[i][j] = false;
			}
		}
	}
}
