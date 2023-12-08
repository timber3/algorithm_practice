import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, n_pow, desX, desY, sum;
	static int[] order;
	static int[][] map;
	static ArrayList[] likes;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1 , 0, 0};
	
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		
		n_pow = (int) Math.pow(n, 2);
		
		likes = new ArrayList[n_pow+1];
		map = new int[n][n];
		order = new int[n_pow];
		
		for (int i = 0 ; i <= n_pow ; i ++) {
			likes[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < n_pow; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int stu = Integer.parseInt(st.nextToken());
			
			order[i] = stu;
			
			for (int j = 0 ; j < 4 ; j ++)
				likes[stu].add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0 ; i < n_pow ; i ++) {			
			sit(i);
		}
		
		// 자리에 다 앉혔으면
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				int temp = 0;
				for (int k = 0 ; k < 4; k ++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					
					if(likes[map[i][j]].contains(map[nx][ny])) {
						temp ++;
					}
				}
				
				if ( temp != 0 ) {
					int score = 1;
					for (int k = 0 ; k < temp - 1; k ++) {
						score *= 10;
					}
					sum += score;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	static void sit(int cur) {
		
		int[][] likeMap = new int[n][n];
		int[][] emptyMap = new int[n][n];
		
		int stu = order[cur];
		// 1. 좋아하는 학생이 근처에 많은 칸 구하기 
		for (int i = 0; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				
				for (int k = 0 ; k < 4 ; k ++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if (nx < 0 || ny < 0 || nx >= n || ny >= n ) {
						continue;
					}
					
					// 칸이 비어있고 만약 주변에 좋아하는 학생이 포함이 되어있다면.
					if (map[i][j] ==0 && likes[stu].contains(map[nx][ny])) {
						likeMap[i][j] ++;
					}
					// 빈공간 계산
					if (map[nx][ny] == 0) {
						emptyMap[i][j] ++;
					}
				}
			}
		}
		
		int likeMax = 0;
		int emptyMax = 0;
		
		int[] likeMaxCnt = new int[5];
		int[] emptyMaxCnt = new int[5];
		
		for (int i = 0; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {		
				// 좋아하는 학생 수 최대값 구하기
				if (likeMap[i][j] >= likeMax) {
					likeMax = likeMap[i][j];
					likeMaxCnt[likeMax] ++;
				}
			}
		}
		
		// 좋아하는 학생 최대값이 하나만 있을 경우
		if (likeMaxCnt[likeMax] == 1) {
			// 해당 좌표를 리턴하면 됨.
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if (likeMap[i][j] == likeMax && map[i][j] == 0) {
						desX = i;
						desY = j;
					}
				}
			}
		}
		// 좋아하는 학생 최대값이 여러개일 경우
		else {
			// like가 최대값인 자리들 중에서 빈 공간 최대값을 구해준다.
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0; j < n ; j ++) {
					
					// like 가 최대값인 자리들 중에서
					if (likeMap[i][j] == likeMax && map[i][j] == 0) {
						// 비어있는 공간 수 최대값 구하기
						if (emptyMap[i][j] > emptyMax) {
							emptyMax = emptyMap[i][j];
							emptyMaxCnt[emptyMax] ++;
						}
					}
				}
			}
			
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0; j < n ; j ++) {
					if (likeMap[i][j] == likeMax && emptyMap[i][j] == emptyMax && map[i][j] == 0) {
						desX = i;
						desY = j;
					}
				}
			}
		}
		
		map[desX][desY] = stu;
	}
}