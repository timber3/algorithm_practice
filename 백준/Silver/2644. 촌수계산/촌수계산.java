import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Currency;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		int cur;
		public Node(int v, int cur) {
			super();
			this.v = v;
			this.cur = cur;
		}
		
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int a, b;
	static int[][] Map;
	static int[] visited;
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken()) - 1;
		b = Integer.parseInt(st.nextToken()) - 1;
		
		m = Integer.parseInt(br.readLine());
		Map = new int[n][n];
		visited = new int[n];
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			Map[from][to] = Map[to][from] = 1;
		}
		
		Arrays.fill(visited, -1);
		
		bfs(a);
		
		System.out.println(visited[b]);
		
	}
	
	static void bfs(int from) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(new Node(a, 0));
		visited[a] = 0;
		
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			
			int cv = temp.v;
			int ccur = temp.cur;
			
			for (int i = 0 ; i < n ; i ++) {
				if (Map[cv][i] == 1 && visited[i] == -1) {
					q.add(new Node(i, ccur + 1));
					visited[i] = ccur+1; 
				}
			}

		}
	}

}
