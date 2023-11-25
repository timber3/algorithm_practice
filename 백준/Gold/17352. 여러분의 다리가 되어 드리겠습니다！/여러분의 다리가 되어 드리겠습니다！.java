import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] parent;
	static int a, b;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		n = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		
		for (int i = 1 ; i <= n ; i ++ ) {
			parent[i] = i;
		}
		
		for (int i = 0 ; i < n-2; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			union(from , to);
		}
		
		for (int i = 1 ; i <= n ; i++ ) {
			find(i);
		}
		
		a = 1;
		
		for (int i = 1 ; i <= n ; i ++) {
			if (parent[i] != parent[1]) {
				b = i;
				break;
			}
		}
		System.out.printf("%d %d", a , b);
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if (a != b) {
			if (a < b) parent[b] = a;
			else parent[a] = b;
		}
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}

}