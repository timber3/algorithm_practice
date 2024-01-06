import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result;
	static int minA, minB;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		minA = Integer.MAX_VALUE;
		minB = Integer.MAX_VALUE;
		
		for (int i = 0; i< m ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 1. 번들로만 살 경우
			// 2. 번들 + 낱개 로 살 경우
			// 3. 낱개로만 살 경우
			
			minA = Math.min(a, minA);
			minB = Math.min(b, minB);

		}
		solve(minA, minB);
		
		System.out.println(result);
	}
	
	static void solve(int a, int b) {
		// 번들로 만 샀을 때
		int set = n / 6;
		if (n % 6 != 0) set++;
		
		int cost1 = set * a;
		
		// 번들 + 낱개로 샀을 때
		set = n / 6;
		int rest = n - (6 * set);
		
		int cost2 = (set * a) + (b * rest);
		
		// 낱개로만 샀을 때
		int cost3 = (n * b);
		
		result = Math.min(Math.min(Math.min(cost1, cost2), cost3), result);
	}
}