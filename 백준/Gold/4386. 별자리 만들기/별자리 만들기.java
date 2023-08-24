import java.util.*;
import java.io.*;

public class Main {
	
	static class Vertex implements Comparable<Vertex> {
		int val;  // 정점 번호
		double weight;  // 트리 정점과 연결했을 때의 간선 비용
		
		public Vertex(int val, double weight) {
			super();
			this.val = val;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static class Star{
		double x;
		double y;
		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static double[][] Map;
	static boolean[] visited;
	static double[] minEdge;
	static Star[] stars;
	static double result;
	
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		
		Map = new double[n+1][n+1];
		visited = new boolean[n+1];
		// 자신과 다른 정점 사이의 거리
		minEdge = new double[n+1];
		stars = new Star[n+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(1, 0));
		
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[1] = 0;
		
		for (int i = 1 ; i <= n ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			stars[i] = new Star(x, y);
		}
		
		for (int i = 1 ; i <= n-1 ; i++ ) {
			for (int j = i+1; j <= n ; j++) {
				if ( i != j ) {
					double temp = Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2);
					temp = Math.sqrt(temp);
					Map[i][j] = temp;
					Map[j][i] = temp;
				}
			}
		}
		
		
		double min = 0;
		int minVertex = 0;
		int cnt = 0;
		
//		for (int c = 1 ; c <= n ; c ++ ) {
		while(!pq.isEmpty()) {
			
			Vertex cur = pq.poll();
			int cv = cur.val;
			double cw = cur.weight;
			
			minVertex = cv;
			min = cw;
			// pq에 남아있던 흔적이 또 나왔을 때 버려줘야 함.
			if (visited[minVertex])
				continue;

			// step1 : 미방문 정점 중 최소간선 비용의 정점 선택
			// step2 : 방문(트리) 정점에 추가
			visited[minVertex] = true;  // 방문 처리
			result += min;  // 신장 트리 비용 누적
			if (++cnt == n) break;  // 빠져 나오기 위한 코드
			
			// step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 업데이트
			for (int i = 1 ; i <= n ; i ++ ) { 
				if (!visited[i] && Map[minVertex][i] != 0 && minEdge[i] > Map[minVertex][i] ) {
					minEdge[i] = Map[minVertex][i];
					pq.add(new Vertex(i, minEdge[i]));
					
				}
			}
			
		}
		
		System.out.printf("%.2f", result);
		
	}
	
}