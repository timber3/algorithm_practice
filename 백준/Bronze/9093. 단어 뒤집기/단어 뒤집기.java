import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<A;i++) {
			String Sentence = br.readLine();
			StringTokenizer str = new StringTokenizer(Sentence);
			while(str.hasMoreTokens()) {
				StringBuilder sb2 = new StringBuilder(str.nextToken()).reverse();
				sb.append(sb2.toString() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}