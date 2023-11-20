import java.util.*;
import java.io.*;

public class Main {
	static int[] array = new int [20000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int A = Integer.parseInt(st.nextToken());
			array[A+10000000]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int B = Integer.parseInt(st.nextToken());
			sb.append(array[B+10000000] + " ");
		}
		System.out.print(sb);
	}
}