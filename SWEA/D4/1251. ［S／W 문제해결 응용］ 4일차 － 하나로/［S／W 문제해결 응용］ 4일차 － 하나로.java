import java.util.*;
import java.io.*;

public class Solution {
	
	static class Node {
		int val;
		double weight;
		public Node(int val, double weight) {
			super();
			this.val = val;
			this.weight = weight;
		}
	}
	
	static class Island {
		int x;
		int y;
		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int T, n;
	static double e; // 환경 세율
	static double[][] Map;
	static boolean[] visited;
	static Island[] islands;
	static double[] minEdge;
	static int[] x, y;
	static double result;
	
	public static void main(String[] args) throws IOException{
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < T ; t ++) {
			
			n = Integer.parseInt(br.readLine());
			
			Map = new double[n+1][n+1];
			visited = new boolean[n+1];
			islands = new Island[n+1];
			minEdge = new double[n+1];
			x = new int[n+1];
			y = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1 ; i <= n ; i ++ ) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1 ; i <= n ; i ++ ) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1 ; i <= n ; i ++ ) {
				islands[i] = new Island(x[i], y[i]);
			}
			
			e = Double.parseDouble(br.readLine());
			
			for (int i = 1 ; i <= n-1 ; i++ ) {
				for (int j = i+1; j <= n ; j++) {
					if ( i != j ) {
						double temp = Math.pow(islands[i].x - islands[j].x, 2) + Math.pow(islands[i].y - islands[j].y, 2);
						Map[i][j] = temp * e;
						Map[j][i] = temp * e;
					}
				}
			}
			
			Arrays.fill(minEdge, Double.MAX_VALUE);

			prim();
			
			System.out.printf("#%d %d\n", t+1, Math.round(result));
			result = 0;
		}
	}
	
	static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
			return Double.compare(a.weight, b.weight);
		}) ;
		
		pq.add(new Node(1, 0));
		
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			int cur = temp.val;
			double min = temp.weight;
			
			if (visited[cur])
				continue;
			
			visited[cur] = true;
			result += min;
			
			if (++cnt == n) {
				break;
			}
			
			for (int i = 1 ; i <= n; i++) {
				if (!visited[i] && Map[cur][i] != 0 && minEdge[i] > Map[cur][i]) {
					minEdge[i] = Map[cur][i];
					pq.add(new Node(i, minEdge[i]));
				}
			}
		}
	}
}
