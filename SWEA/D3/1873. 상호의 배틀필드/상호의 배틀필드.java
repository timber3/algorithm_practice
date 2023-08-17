import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T, h, w, n;
	static char[] input;
	static char[][] Map;
	static int tx, ty;
	static char td;
	static int bx, by;
	
	
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < T ; t ++) {
			
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			Map = new char[h][w];
			
			for (int i = 0 ; i < h ; i ++) {
				
				String str = br.readLine();
				
				for (int j = 0 ; j < w ; j++) {
					Map[i][j] = str.charAt(j); 
					if (Map[i][j] == '<' || Map[i][j] == '>' ||
							Map[i][j] == '^' || Map[i][j] == 'v') {
						tx = i;
						ty = j;
						td = Map[i][j];
					}
				}
			}
			
			n = Integer.parseInt(br.readLine());
			
			input = new char[n];
			
			String str = br.readLine();
		
			for (int i = 0 ; i < n ; i++) {
				input[i] = str.charAt(i); 
			}
			
			/*
				문자 의미
				.	평지(전차가 들어갈 수 있다.)
				*	벽돌로 만들어진 벽
				#	강철로 만들어진 벽
				-	물(전차는 들어갈 수 없다.)
				^	위쪽을 바라보는 전차(아래는 평지이다.)
				v	아래쪽을 바라보는 전차(아래는 평지이다.)
				<	왼쪽을 바라보는 전차(아래는 평지이다.)
				>	오른쪽을 바라보는 전차(아래는 평지이다.)
				
				문자	동작
				U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
				D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
				L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
				R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
				S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
			 * 
			 */
			
			
			for (int i = 0 ; i < n ; i ++) {
				
				switch(input[i]) {
					case 'U':
						Map[tx][ty] = '^';
						td = '^';
						if (tx-1 >= 0 && Map[tx-1][ty] == '.') {
							Map[tx][ty] = '.'; 
							tx = tx-1;
							Map[tx][ty] = '^';
							
						}
						break;
					case 'D':
						Map[tx][ty] = 'v';
						td = 'v';
						if (tx+1 < h && Map[tx+1][ty] == '.') {
							Map[tx][ty] = '.'; 
							tx = tx+1;
							Map[tx][ty] = 'v';
						}
						break;
					case 'L' :
						Map[tx][ty] = '<';
						td = '<';
						if (ty-1 >= 0 && Map[tx][ty-1] == '.') {
							Map[tx][ty] = '.'; 
							ty = ty-1;
							Map[tx][ty] = '<';
						}
						break;
					case 'R' :
						Map[tx][ty] = '>';
						td = '>';
						if (ty+1 < w && Map[tx][ty+1] == '.') {
							Map[tx][ty] = '.'; 
							ty = ty+1;
							Map[tx][ty] = '>'; 
						}
						break;
					case 'S' :
						shoot(td);
						break;
				}
				
			}
			
			System.out.printf("#%d ", t+1);
			for (int i = 0 ; i < h ; i ++) {
				for (int j = 0 ; j < w ; j ++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}

		}
	}
	
	static void shoot(char dir) {
		switch(dir) {
		case '^':
			bx = tx-1;
			by = ty;
			
			while (bx >= 0 && Map[bx][by] != '#') {
				if (Map[bx][by] == '*') {
					Map[bx][by] = '.';
					break;
				} else {					
					bx--;
				}
			}
			break;
		case 'v':
			bx = tx+1;
			by = ty;
			
			while (bx < h && Map[bx][by] != '#') {
				if (Map[bx][by] == '*') {
					Map[bx][by] = '.';
					break;
				} else {					
					bx++;
				}
			}
			break;
		case '<':
			bx = tx;
			by = ty-1;
			
			while (by >= 0 && Map[bx][by] != '#') {
				if (Map[bx][by] == '*') {
					Map[bx][by] = '.';
					break;
				} else {					
					by--;
				}
			}
			break;
		case '>':
			bx = tx;
			by = ty+1;
			
			while (by < w && Map[bx][by] != '#') {
				if (Map[bx][by] == '*') {
					Map[bx][by] = '.';
					break;
				} else {					
					by++;
				}
			}
			break;
		}
	}
	

}
