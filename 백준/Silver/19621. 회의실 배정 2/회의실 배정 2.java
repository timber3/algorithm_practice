import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {
	
	static class Meeting{
		int start;
		int end;
		int number;
		
		public Meeting(int start, int end, int number) {
			this.start = start;
			this.end = end;
			this.number = number;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static Meeting[] meetings;
	static int sum;
	static int cur;
	static int Max;

	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		meetings = new Meeting[n];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			meetings[i] = new Meeting(start, end, number);
		}
		
		Arrays.sort(meetings, (a, b) -> {
			return (a.end == b.end) ? (a.start == b.start) ? b.number - a.number : a.start- b.start : a.end - b.end;
		});

//		for (Meeting m : meetings) {
//			System.out.println(m.start + " " + m.end + " " + m.number);
//		}
	
		combi(0, 0);
		
		System.out.println(Max);
	}
	
	static void combi(int sum, int idx) {
		
		for (int i = idx ; i < meetings.length ; i ++) {
			if (cur <= meetings[i].start) {
				int temp = cur;
				cur = meetings[i].end;
				combi(sum + meetings[i].number , i+1);
				cur = temp;
			}
		}
		
		Max = Math.max(sum, Max);
		
	}

}
