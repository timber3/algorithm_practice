import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Case = Integer.parseInt(br.readLine());
		for(int i=0;i<Case;i++) {
			String result = "YES";
			Stack<String> stk = new Stack<>();
			stk.push("1");
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == '(') {
					stk.push("(");
				}
				else { // str.charAt(j) == ')'
					if(stk.peek().equals("(")) {
						stk.pop();
					}
					else {
						stk.push(")");
					}
				}
			}
			stk.pop();
			if(!stk.empty()) {
				result = "NO";
			}
			System.out.println(result);
			//sb.append(result +"\n");
		}
	}
}