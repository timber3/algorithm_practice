import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, n;
	static String p;
	static int front = 1;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < T ; t ++) {
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			Stack<Integer> stack = new Stack<>();
			
			front = 1;
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "\n[,]");
			
			boolean error_occured = false;
			/*sb = new StringBuilder();*/
			
			// Q에 배열에서 받은 숫자들 넣어주기.
			for (int i = 0 ; i < n ; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0 ; i < p.length() ; i++) {
				
				if(p.charAt(i) == 'R' ) {
					front *= -1;
				}
				else if (p.charAt(i) == 'D' ) {
					
					if (q.isEmpty()) {
						error_occured = true;
						break;
					}
					
					if (front == 1) {						
						q.poll();
					} else {
						q.pollLast();
					}
				}
			}
			
			if(error_occured) {
				sb.append("error\n");
				continue;
			}
			
			int size = q.size();

			sb.append("[");
			
			for (int i = 0 ; i < size; i ++) {
				if (front == 1) {
					if (i == size-1) {
						sb.append(q.pollFirst());
						break;
					}
					sb.append(q.pollFirst()+",");					
				} 
				else if (front == -1) {
					if (i == size-1) {
						sb.append(q.pollLast());
						break;
					}
					
					sb.append(q.pollLast()+",");
				}
			}
			
			sb.append("]\n");

		}
		System.out.print(sb);
	}

}
