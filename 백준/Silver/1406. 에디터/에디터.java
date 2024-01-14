import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static String str;
	static Stack<Character> stackLeft = new Stack<>();
	static Stack<Character> stackRight = new Stack<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i ++) {
			stackLeft.push(str.charAt(i));
		}
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			char a = st.nextToken().charAt(0);
			char b;
			if (a == 'P') {
				b = st.nextToken().charAt(0);
				stackLeft.push(b);
			}
			
			if (a == 'L' && !stackLeft.isEmpty()) {
				stackRight.push(stackLeft.pop());
			}
			
			if (a == 'D' && !stackRight.isEmpty()) {
				stackLeft.push(stackRight.pop());
			}
			
			if ( a == 'B' && !stackLeft.isEmpty()) {
				stackLeft.pop();
			}
		}
		
		int total_length = stackLeft.size() + stackRight.size();
		char[] result = new char[total_length];
		
		while(!stackLeft.isEmpty()) {
			result[stackLeft.size()-1] = stackLeft.pop();
		}
		
		while(!stackRight.isEmpty()) {
			result[total_length - stackRight.size()] = stackRight.pop();
		}
		
		for (int i = 0 ; i < total_length ; i ++) {
			sb.append(result[i]);
		}
		
		System.out.println(sb);
	}
}