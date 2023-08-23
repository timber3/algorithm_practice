import java.util.*;
import java.io.*;

public class Solution {
	
	static class Edge {
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
	
	static int n, v, e;
	static int[] parents;
	static Edge[] edges;
	static long result, usedEdge;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T ; t++)
		{
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			parents = new int[v+1];
			edges = new Edge[e];
			
			makeSet();
			
			for (int i = 0 ; i < e ; i ++) { 
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(a, b, c);
			}
			
			// Kruskal을 위한 전처리 과정
			Arrays.sort(edges, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.weight, o2.weight) ;
				}
			});
			
			for (int i = 0 ; i < e ; i ++ ) { 
				if (usedEdge == v-1)
					break;
				if (unionSet(edges[i].a, edges[i].b)) {
					result += edges[i].weight;
					usedEdge++;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, result);
			result = 0; usedEdge = 0;
		}
		
	}
	
	static void makeSet() {
		for (int i = 1 ; i <= v; i ++ ) {
			parents[i] = i;
		}
	}
	
	// 합쳤을 때 부모가 같다면 false 리턴, 다르면 합쳐주고 true 리턴
	static boolean unionSet(int a, int b) {
	
		int aTop = findSet(a);
		int bTop = findSet(b);
		
		if (aTop == bTop) {
			return false;
		}
		parents[bTop] = aTop;
		return true;
	}
	
	static int findSet(int cur) {
		if (parents[cur] == cur) {
			return cur;
		}else {
			return parents[cur] = findSet(parents[cur]);
		}
	}

}

