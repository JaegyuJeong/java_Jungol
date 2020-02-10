package intermediateCoder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[100][3];
		int[] tmp = new int[2];
		int chemi_cnt = 0;
		int refri_cnt = 0;
		int max_temp= 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
			temp[i][2] = 0;
		}

		//-----------------정렬-----------------------------
		for (int i = N-1; i >=1; i--) {
			for (int j = 0; j < i; j++) {
				if (temp[j][0] > temp[j + 1][0]) {
					tmp[0] = temp[j][0];
					tmp[1] = temp[j][1];

					temp[j][0] = temp[j + 1][0];
					temp[j][1] = temp[j + 1][1];

					temp[j + 1][0] = tmp[0];
					temp[j + 1][1] = tmp[1];
				}
			}
		}
		
		while(chemi_cnt != N) {
			max_temp = 10000;
			for(int i = 0 ; i<N;i++) {
				if(temp[i][2] == 0 &&max_temp>=temp[i][0]) {
					temp[i][2] = 1;
					chemi_cnt++;
					if(max_temp > temp[i][1]) {
						max_temp = temp[i][1];
					}
				}
			}
			refri_cnt++;
		}
		System.out.println(refri_cnt);

	}

}
