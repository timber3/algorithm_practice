import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] Map;
	static boolean[] chickVisited;
	static List<Node> houses = new ArrayList<>();
	static List<Node> chickens = new ArrayList<>();
	static List<Node> selected = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map = new int[n][n];
		chickVisited = new boolean[m];
		
		for (int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < n ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				
				if (Map[i][j] == 1 ) {
					houses.add(new Node(i, j));
				}
				if (Map[i][j] == 2 ) {
					chickens.add(new Node(i, j));
				}
			}
		}
		
		combi(0, 0);
		
		System.out.println(result);

	}
	
	static void combi(int cnt, int idx) {
		
		// 치킨집을 m개 골랐을 때
		if (cnt == m) { 
			
			int sum = 0;
			
			for (int i = 0 ; i < houses.size() ; i ++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0 ; j < selected.size(); j ++) {
					int d = Math.abs(houses.get(i).x - selected.get(j).x) + Math.abs(houses.get(i).y - selected.get(j).y);
					min = Math.min(min, d);
				}
				sum += min;
			}
			
			result = Math.min(sum, result);
			return;
		}
		
		
		// 조합 구현
		for (int i = idx ; i < chickens.size(); i ++) {
			selected.add(chickens.get(i));
			combi(cnt+1, i+1);
			selected.remove(selected.size() -1);
		}
	}
}

