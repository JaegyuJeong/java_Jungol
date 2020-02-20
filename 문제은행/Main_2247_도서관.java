package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Library {
	int start;
	int end;
}

public class Main_2247_도서관 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Library[] lib = new Library[N];
//		int[] arr = new int[400000];
		for (int i = 0; i < N; i++) {
			lib[i] = new Library();
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			lib[i].start = Integer.parseInt(st.nextToken());
			lib[i].end = Integer.parseInt(st.nextToken());

//			for (int j = a; j <= b; j++) {
//				arr[j]++;
//			}
		}

		Arrays.sort(lib, new Comparator<Library>() {

			@Override
			public int compare(Library o1, Library o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				} else {
					return o1.start - o2.start;
				}
			}
		});

		int start = lib[0].start;
		int end = lib[0].end;
		int f_max = 0;
		int v_max = 0;

//		for (int i = 0; i < lib.length; i++) {
//			System.out.println("[" + lib[i].start + "][" + lib[i].end + "]");
//		}
		for (int i = 1; i < lib.length; i++) {
			if (end >= lib[i].start) {
				if (lib[i].end > end) {
					end = lib[i].end;
				}
				if (f_max < end - start) {
					f_max = end - start;
				}
			} else {
				if (v_max < lib[i].start - end) {
					v_max = lib[i].start - end;
				}
				if (f_max < lib[i].end - lib[i].start) {
					start = lib[i].start;
					end = lib[i].end;
					f_max = lib[i].end - lib[i].start;
				} else {
					start = lib[i].start;
					end = lib[i].end;
				}
			}
		}
//		Arrays.sort(lib, new Comparator<Library>() {
//
//			@Override
//			public int compare(Library o1, Library o2) {
//				if (o1.end == o2.end) {
//					return o2.start - o1.start;
//				} else {
//					return o2.end - o1.end;
//				}
//			}
//		});

//		int v_max = lib[0].start;
//		for (int i = 1; i < lib.length; i++) {
//			if (v_max < lib[i].end) {
//				if (v_max > lib[i].start)
//					v_max = lib[i].start;
//			} else {
//				list.add(v_max - lib[i].end - 2);
//				v_max = lib[i].start;
//			}
//		}
//
//		for (int i : list) {
//			if (v_max < i) {
//				v_max = i;
//			}
//		}

		System.out.println(f_max + " " + v_max);
	}

}
