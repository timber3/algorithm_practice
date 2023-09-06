import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, numcnt;
//	static int[] arr;
	static ArrayList<Integer> arr; 
	static boolean[] already, visited;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
//		arr = new int[n];
		arr = new ArrayList<>();
//		visited = new boolean[n];
		result = new int[m];
		already = new boolean[10001];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < n ; i ++) {
			int val = Integer.parseInt(st.nextToken());
			if (already[val] == false) {
				already[val] = true;
//				arr[numcnt++] = val;
				arr.add(val);
			}
		}
		
		Collections.sort(arr);
		
		perm(0, 0);
		
		System.out.println(sb);
		
	}
	
	static void perm(int cnt ,int idx) {
		
		if (cnt == m) {
			for (int i = 0 ; i < m ; i ++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx ; i < arr.size(); i ++) {
			result[cnt] = arr.get(i);
			perm(cnt+1, i);
		}
	}
}

