import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.crypto.NodeSetData;

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
	static int sum;
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException{
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T ; t ++ ) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			nodes = new Node[n+1];
			
			for (int i = 1; i <= n ; i++) {
				nodes[i] = new Node(i);
			}
			
			for (int i = 0 ; i < m ; i++ ) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (a < b) {
					unionSet(a, b);
				} else {
					unionSet(b, a);
				}
			}
			
			for (int i = n ; i >= 1 ; i-- ) {
				//findSet(i);
				if (nodes[i].parent == i) {
					sum ++;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, sum);
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