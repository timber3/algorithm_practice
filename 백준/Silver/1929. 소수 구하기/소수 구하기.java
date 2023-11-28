import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		boolean bool[] = new boolean[N+1];
		Arrays.fill(bool, true);
		for(int i=2;i<=N;i++) {		
			if(!bool[i]) {
				continue;
			}
			int A = i;
			while(A+i<=N) {
				A+=i;
				bool[A] = false;
			}
		}
		bool[1] = false;
		for(int i = M;i<=N;i++) {
			if(bool[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.print(sb);
	}
}