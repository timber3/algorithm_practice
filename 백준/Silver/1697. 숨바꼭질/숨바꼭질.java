import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.security.auth.x500.X500Principal;

public class Main{

	static class Node {
		int cur;
		int v;
		public Node(int cur, int v) {
			super();
			this.cur = cur;
			this.v = v;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, result;    
	static int[][] Map;
	static int[] visited;
	static int a, b;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		Arrays.fill(visited, -1);
		
		solve(a);
		System.out.println(visited[b]);
	}
	
	static void solve(int a) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(a, 0));
		visited[a] = 0;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int ccur = temp.cur;
			int cv = temp.v;
			
			int nx1 = ccur - 1;
			int nx2 = ccur + 1;
			int nx3 = ccur * 2;
			
			if (inRange(nx1) && visited[nx1] == -1 ){
				visited[nx1] = cv + 1;
				q.add(new Node(nx1, cv+1));
			}
			if (inRange(nx2) && visited[nx2] == -1 ){
				visited[nx2] = cv + 1;
				q.add(new Node(nx2, cv+1));
			}
			if (inRange(nx3) && visited[nx3] == -1 ){
				visited[nx3] = cv + 1;
				q.add(new Node(nx3, cv+1));
			}
		}
	}
	
	static boolean inRange(int cur) {
		
		if (cur < 0 || cur > 100000)
			return false;
		
		return true;
	}
}