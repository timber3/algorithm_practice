import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, Max;
	static int[] arr, result;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		result = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			result[i] = 1;
		}
		
		
		
		// n^2의 풀이
		
		for (int i = 1 ; i < n ; i++) {
			for (int j = 0 ; j < i ; j ++) {
				if (arr[j] < arr[i])
				{
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
		}
		
		for (int i = 0 ; i < n ; i ++) {
			Max = Math.max(result[i], Max);
		}
		
		System.out.println(Max);
		
	}
	
}