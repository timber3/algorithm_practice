import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int v;
		int cost;
		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, x;
	static int[] d;
	static ArrayList<Node>[] list;
	static int INF = Integer.MAX_VALUE;
	static int[] cd, result;
	static int Max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) -1;
		
		d = new int[n];
		cd = new int[n];
		result = new int[n];
		
		list = new ArrayList[n];
		
		for (int i = 0 ; i < n ; i ++) {
			list[i] = new ArrayList<>();
			d[i] = INF;
		}
		

		for (int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
		}
		
		
		// c 에서 시작해서 모든 정점까지의 거리 구하기
		int start = x;
		dijkstra(start);
		
		for (int i = 0 ; i < n ; i ++) {
			cd[i] = d[i]; 
		}		
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				d[j] = INF;
			}
			
			if (i != x)
			{
				dijkstra(i);
				// i 에서 x 까지의 최단 거리 ㅣㅏ,ㅏㅣㅏㅣㅏ;구했음.
				result[i] = d[x];
			}
		}
		
		for (int i = 0 ; i < n; i ++) {
			if(cd[i] != INF && result[i] != INF )
				Max = Math.max(Max, result[i]+ cd[i]);
		}
		
		System.out.println(Max);
		
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(a,b) -> { return Integer.compare(a.cost, b.cost); });
		
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) { 
			Node next = pq.poll();
			
			int dist = next.cost;
			int now = next.v;
			
			// 선택된 노드로 가는 길 보다 이미 더 빠른 길이 있다면 볼 필요 없음.
			if (d[now] < dist) continue;
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인한다.
			for (int i = 0 ; i < list[now].size() ; i ++) {
				// 현재까지 오는 비용 + 다음 가는 비용
				int c = d[now] + list[now].get(i).cost;
				// 다음 까지 거리 (이전에 저장된 기록)
				int c2 = d[list[now].get(i).v];
				if ( c < c2 ) { 
					d[list[now].get(i).v] = c;
					pq.add(new Node(list[now].get(i).v, c));
				}
			}
		}
		
		
	}
	
}