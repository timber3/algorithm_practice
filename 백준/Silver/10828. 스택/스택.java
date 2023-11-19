import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stackInt = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			StringTokenizer str = new StringTokenizer(s);
			String st = str.nextToken();
			switch(st) {
				case "push":
					int A = Integer.parseInt(str.nextToken());
					stackInt.push(A);
					break;
				case "pop":
					if(stackInt.isEmpty()) {
						sb.append(-1 + "\n");
					}
					else {
						sb.append(stackInt.pop() + "\n");
					}
					break;
				case "size":
					sb.append(stackInt.size() + "\n");
					break;
				case "empty":
					if(stackInt.isEmpty()) {
						sb.append(1 + "\n");
					}
					else {
						sb.append(0 + "\n");
					}
					break;
				case "top" :
					if(stackInt.isEmpty()) {
						sb.append(-1 + "\n");
					}
					else {
						sb.append(stackInt.peek() + "\n");
					}
			}
		}
		System.out.println(sb);
	}
}