import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		for(int i=0;i<A;i++) {
			StringBuilder sb = new StringBuilder();
			String Sentence = br.readLine();
			StringTokenizer str = new StringTokenizer(Sentence);
			while(str.hasMoreTokens()) {
				StringBuilder sb2 = new StringBuilder(str.nextToken()).reverse();
				sb.append(sb2.toString() + " ");
			}
			System.out.println(sb);
		}
	}
}