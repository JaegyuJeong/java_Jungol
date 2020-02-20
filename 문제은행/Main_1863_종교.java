package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i < parent.length; i++) {
			makeSet(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			union(u, v);
		}
		int cnt = 0;

//		Arrays.sort(parent);

//		int tmp = parent[1];
		for (int i = 1; i < parent.length; i++) {
			if (i == parent[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void union(int u, int v) {
		parent[findSet(u)] = findSet(v);

	}

	static int findSet(int v) {
		if (parent[v] == v) {
			return v;
		}
		parent[v] = findSet(parent[v]);
		return parent[v];
	}

	static void makeSet(int v) {
		parent[v] = v;
	}

}
