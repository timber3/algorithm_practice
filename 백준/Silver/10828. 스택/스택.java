import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stackInt = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			StringTokenizer str = new StringTokenizer(s);
			String st = str.nextToken();
			if(st.equals("push")) {
				int A = Integer.parseInt(str.nextToken());
				stackInt.push(A);
			}
			else if(st.equals("pop")) {
				if(stackInt.size() == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(stackInt.pop());
				}
			}
			else if(st.equals("size")) {
				System.out.println(stackInt.size());
			}
			else if(st.equals("empty")) {
				if(stackInt.empty()) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
			}
			else if(st.equals("top")) {
				if(stackInt.size() == 0) {
					System.out.println("-1");
				}
				else {
					System.out.println(stackInt.peek());
				}
			}
		}
	}
}