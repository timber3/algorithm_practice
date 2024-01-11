import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static ArrayList<Integer>[] tree;
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		parent = new int[n+1];
		
		for (int i = 1 ; i <= n ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 1 ; i <= n ; i++) {
			parent[i] = -1;
		}
		
		for (int i = 0 ; i < n-1 ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[b].add(a);
			tree[a].add(b);
			
		}
		
		dfs(1);
		
		for (int i = 2 ; i <= n ; i ++) {
			System.out.println(parent[i]);
		}
	}
	
	static void dfs(int cur) {
		int size = tree[cur].size();
		
		for (int i = 0 ; i < size ; i ++) {
			int val = tree[cur].get(i);
			if (parent[val] == -1) {
				parent[val] = cur;
				dfs(val);
			}
		}
		return;
	}
}