import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node {
		int parent;

		public Node(int parent) {
			super();
			this.parent = parent;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, T;
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException{
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ;t < T ; t ++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			nodes = new Node[n+1];
			
			for (int i = 1 ; i <= n ;  i ++) {
				nodes[i] = new Node(i);
			}
			
			System.out.printf("#%d ", t+1);
			
			for (int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(op) {
				case 0:
					unionSet(a, b);
					break;
				case 1:
					if (sameParent(a, b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
					break;
				}	
			}
			
			System.out.println();
		}
	}
	
	static void makeSet() {
		for (int i = 1 ; i <= n ; i++ ) {
			nodes[i].parent = i;
		}
	}
	
	static int findSet(int cur) {
		if (cur == nodes[cur].parent) {
			return cur;
		} else {
			return nodes[cur].parent = findSet(nodes[cur].parent);
		}
	}
	
	static void unionSet(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		
		nodes[bParent].parent = aParent;
	}
	
	static boolean sameParent(int a, int b) {
		int aParent = findSet(a);
		int bParent = findSet(b);
		
		if (aParent == bParent)
			return true;
		
		return false;
	}
	
}
