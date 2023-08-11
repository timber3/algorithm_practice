import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class meeting{
		int start;
		int end;
		
		public meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static meeting[] meetings;
	
	
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		
		meetings = new meeting[n];
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			meetings[i] = new meeting(a,b); 
		}
		
		Arrays.sort(meetings, (a, b) -> {
			return (a.end != b.end) ? a.end - b.end : a.start - b.start ;
		} );
		// 정렬 끝
		
		// 현재 시간
		int cur = 0;
		int sum = 0;
		
		for (int i = 0 ; i < meetings.length ; i ++) {
			if (meetings[i].start >= cur) {
				cur = meetings[i].end;
				sum ++;
			}
		}
		
		System.out.println(sum);
		
	}

}
