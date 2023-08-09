import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, r;
	static int[][] Map;
	static int[] oper = new int[1001];
	
	static ArrayDeque<Integer> q;
	

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		Map = new int[n][m];
		q = new ArrayDeque<>();

		
		for (int i = 0 ; i < n ;i  ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j ++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < r ; i ++) {
			oper[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for (int i = 0 ; i < r ; i ++) {
			switch(oper[i]) {
			case 1:
				upToDown();
				break;
			case 2:
				leftToRight();
				break;
			case 3:
				turnRight();
				break;
			case 4:
				turnRight();
				turnRight();
				turnRight();
				break;
			case 5:
				windmillRight();
				break;
			case 6:
				windmillRight();
				windmillRight();
				windmillRight();
				break;
			}
		}
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0; j < m ; j ++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	static void upToDown() {
		for (int i = 0 ; i < m; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				q.add(Map[j][i]);
			}
			for (int j = 0 ; j < n ; j ++) {
				Map[j][i] = q.pollLast();
			}
		}
	}
	
	static void leftToRight() {
		
		for (int i = 0 ; i < n; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				q.add(Map[i][j]);
			}
			for (int j = 0 ; j < m ; j ++) {
				Map[i][j] = q.pollLast();
			}
		}
	}
	
	static void turnRight() {
		
		int[][] temp = new int[m][n];
		
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				q.add(Map[i][j]);
			}
			for (int j = 0 ; j < m ; j++) {
				temp[j][n-i-1] = q.pollFirst(); 
			}
		}
		
		int t = n;
		n = m;
		m = t;
		
		Map = temp;
	}
	
	static void windmillRight() {
		
		int[][] temp = new int[n][m];
		
		int hn = n/2;
		int hm = m/2;
		
		ArrayDeque<Integer> q2 = new ArrayDeque<>();
		ArrayDeque<Integer> q3 = new ArrayDeque<>();
		ArrayDeque<Integer> q4 = new ArrayDeque<>();
		
		for (int i = 0 ; i < hn ; i ++) {
			
			for (int j = 0 ; j < hm ; j ++) {
				q.add(Map[i][j]);
				q2.add(Map[i][j+hm]);
				q3.add(Map[i+hn][j+hm]);
				q4.add(Map[i+hn][j]);
			}
			
			for (int j = 0 ; j < hm ; j++) {
				temp[i][j+hm] = q.pollFirst();
				temp[i+hn][j+hm]= q2.pollFirst();
				temp[i+hn][j]= q3.pollFirst();
				temp[i][j]= q4.pollFirst();
			}
		}
		
		Map = temp;
		
	}

}
