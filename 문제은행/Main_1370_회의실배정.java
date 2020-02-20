package 문제은행;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Time {
	int no;
	int start;
	int end;
}

public class Main_1370_회의실배정 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		Time[] times = new Time[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = new Time();
			times[i].no = Integer.parseInt(st.nextToken());
			times[i].start = Integer.parseInt(st.nextToken());
			times[i].end = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(times, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				} else {
					return o1.end - o2.end;
				}
			}

		});

		
		int min = times[0].end;
		int cnt = 1;
		LinkedList<Time> list = new LinkedList<>();
		list.add(times[0]);
		for (int i = 1; i < T; i++) {
			if (min <= times[i].start) {
				cnt++;
				min = times[i].end;
				list.add(times[i]);
			}
		}
		System.out.println(cnt);
		for (Time i : list) {
			System.out.print(i.no+" ");
		}

	}

}
