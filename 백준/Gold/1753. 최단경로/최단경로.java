import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		
		int v;
		int weight;
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}	
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	// 정점 개수, 간선 개수, 시작, 도착 인덱스
	static int v, e, start, end;
	static ArrayList<Node>[] Map;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		Map = new ArrayList[v];
		dist = new int[v];
		visited = new boolean[v];
		
		for (int i = 0 ; i < v ; i ++ ) {
			Map[i] = new ArrayList<>();
		}
		
		start = Integer.parseInt(br.readLine()) - 1;
		
		for (int i = 0 ; i < e ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			Map[from].add(new Node(to, weight));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra();
		
		for (int i = 0 ; i < v ; i ++ ) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
			return Integer.compare(a.weight, b.weight);
		});
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		// 다익스트라로 구한 정점
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			int cv = temp.v;
			int cw = temp.weight;
			
			// 이미 방문된 곳이면 다시 뽑기
			if (visited[cv]) continue;
			
			// 방문 체크
			visited[cv] = true;
			
			// 구해진 정점 개수만큼 채웠으면 나가기
			cnt ++;
			if (cnt == v) break;
			
			// 현재 연결된 정점에서 연결된 다른 정점의 비용 업데이트 + 큐에 넣기
			// 최단 거리가 구해지지 않은 정점을 업데이트 해야함.
			for(Node node : Map[cv]) {
				if (visited[node.v]) continue;
				if (dist[node.v] > dist[cv] + node.weight ) {
					dist[node.v] = dist[cv] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
			
		}
	}
	
}
