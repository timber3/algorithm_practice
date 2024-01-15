import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int result = Integer.MAX_VALUE;
	static int t1, t2, t3, t4;
	static Node[] arr;
	static int[] used, visited;
	
	static class Node {
		int t1;
		int t2;
		int t3;
		int t4;
		int cost;
		public Node(int t1, int t2, int t3, int t4, int cost) {
			super();
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.t4 = t4;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4 + ", cost=" + cost + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new Node[n];
		used = new int[n];
		visited = new int[n];
			
		st = new StringTokenizer(br.readLine());
		
		t1 = Integer.parseInt(st.nextToken());
		t2 = Integer.parseInt(st.nextToken());
		t3 = Integer.parseInt(st.nextToken());
		t4 = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			int a4 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(a1, a2, a3, a4, c);
			
		}
		
		dfs(0,0,0,0,0,0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {			
			System.out.println(result);
			
			for (int i = 0 ; i < n ; i++) {
				if (used[i] == 1) {
					System.out.printf("%d ", i+1);
				}
			}
		}

	}
	
	static void dfs(int sum1, int sum2, int sum3, int sum4, int cost, int idx) {
		// 백트래킹
		if (cost >= result) {
			return;
		}
		
		// 탈출 조건
		if (cost < result && needs(sum1, sum2, sum3, sum4)) {
			result = cost;
			for (int i = 0 ; i < n ; i ++) {
				used[i] = visited[i];
			}
			return;
		}
			
		// 선택
		for (int i = idx; i < n ; i ++) {
			if (visited[i] != 1) {
				visited[i] = 1;
				dfs(sum1 + arr[i].t1, sum2 + arr[i].t2, sum3 + arr[i].t3, sum4 + arr[i].t4, cost + arr[i].cost, i);
				visited[i] = 0;
			}
		}
		
	}
	
	static boolean needs(int a, int b, int c, int d) {
		if (a >= t1 && b >= t2 && c >= t3 && d >= t4)
			return true;
		return false;
	}

}