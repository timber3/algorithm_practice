import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 7 
		int [] array = new int [N]; 
		int [] result = new int [N];
		Stack<Integer> S = new Stack<>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(str.nextToken()); //  3 5 2 1 0 4 6 
			result[i] = -1; // -1 -1 -1 -1 -1 -1 -1
		}
		for(int i=0;i<N-1;i++) {
			if(array[i] < array[i+1]) {
				result[i] = array[i+1];
				while(!S.isEmpty()) {
					if(array[i+1] > array[S.peek()]) {
						result[S.peek()] = array[i+1];
						S.pop();
					}
					else {
						break;
					}
				}
			}
			else {
				S.push(i);
			}
		}
		for(int i=0;i<N;i++) {
			sb.append(result[i] + " ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}