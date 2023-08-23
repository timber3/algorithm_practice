import java.util.*;
import java.io.*;

public class Main {
	
	static class Edge{
		int a;
		int b;
		int weight;
		public Edge(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static int[] parent;
	static Edge[] edges;
	static int sum, used;
	
	public static void main(String[] args) throws IOException{
		
		// 정점 수
		n = Integer.parseInt(br.readLine());
		// 간선 수
		m = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		edges = new Edge[m];
		
		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, c);
		}
		
		makeSet();
		
		Arrays.sort(edges, (a, b) -> {
			return Integer.compare(a.weight, b.weight);
		});
		
		for (int i = 0 ; i < m ; i++ ) {
			if (used == n-1) {
				break;
			}
			
			if (unionSet(edges[i].a, edges[i].b)) {
				sum += edges[i].weight;
				used++;
			}
		}
		
		System.out.println(sum);
		
	}
	
	static void makeSet() {
		for (int i = 1; i <= n ; i++) {
			parent[i] = i;
		}
	}
	
	static boolean unionSet(int a, int b) {
		int aTop = findSet(a);
		int bTop = findSet(b);
		
		if (aTop == bTop) {
			return false;
		}
		
		parent[bTop] = aTop;
		return true;
	}
	
	static int findSet(int cur) {
		if (parent[cur] == cur) {
			return cur;
		} else {
			return parent[cur] = findSet(parent[cur]);
		}
	}
}
