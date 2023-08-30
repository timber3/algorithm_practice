import java.io.*;
import java.util.*;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, big, small;
    static long result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		
		for (int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		
		big = Integer.parseInt(st.nextToken());
		small = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < n ; i ++) {
			arr[i] -= big; 
		}
		result = n;
		
		for (int i = 0; i < n ; i ++) {
			if (arr[i] > 0) {
				int val = arr[i] / small;
				if (arr[i]%small != 0)
					val++;
				
				result += val;
			}
		}
		System.out.println(result);
	}
}