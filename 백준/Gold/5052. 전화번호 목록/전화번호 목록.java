import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int T, n;
	static String[] input;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T ; t ++ ) {
			n = Integer.parseInt(br.readLine());
			
			input = new String[n];
			
			for (int i = 0 ; i < n ; i++ ) {
				String str = br.readLine();
				input[i] = str;
			}
			
			Arrays.sort(input);
			
			int flag = 0;
			
			for (int i = 1 ; i < input.length ; i ++) {
				if (input[i].startsWith(input[i-1])) {
					System.out.println("NO");
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				System.out.println("YES");
			
		}
	}
}