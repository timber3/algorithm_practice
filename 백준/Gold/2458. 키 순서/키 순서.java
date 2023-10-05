import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int T, N, M, result;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][N+1];

        for (int i = 0 ; i < M ; i ++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a < b
            map[a][b] = true;

        }

        for (int i = 1 ; i < N+1 ; i ++) {
            int u = upbfs(i);
            int d = downbfs(i);

            if (u + d == N - 1) {
                result++;
            }
        }

        System.out.println(result);

	}
	
	static int upbfs(int cur) {
		
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for (int i = 1 ; i < N+1 ; i ++) {
				if (map[temp][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 1; i < N+1 ; i ++) {
			if (visited[i])
				cnt ++;
		}
		
		return cnt-1;
	}
	
	static int downbfs(int cur) {
		
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for (int i = 1 ; i < N+1 ; i ++) {
				if (map[i][temp] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 1; i < N+1 ; i ++) {
			if (visited[i])
				cnt ++;
		}
		
		return cnt-1;
	}
}