import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	// 동 서 남 북 순서
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] map;

	static int n, m, roll_count, result, count;
	static int[] rx, ry; // 0 빨간공 1 파란공
	static boolean redIn, blueIn;

	// 1. 빨, 파 가 동시에 빠지면 실패
	// 2. 빨 파 동시에 같은 곳에 있을 수 없음
	// 3. 구슬이 움직이지 않을 때 까지 기울이기를 함.
	// goal : 최소 몇 번 만에 빨간 구슬을 빼 낼수 있을까?
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		rx = new int[2];
		ry = new int[2];

		map = new char[n][m];

		// 빨간 구슬, 파랑 구슬 입력 받기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					rx[0] = i;
					ry[0] = j;
				} else if (map[i][j] == 'B') {
					rx[1] = i;
					ry[1] = j;
				}
			}
		}

		bt(0, map, rx, ry, redIn, blueIn);

		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);			
		}
	}


	static void bt(int idx, char[][] map, int[] rx, int[] ry, boolean redIn, boolean blueIn) {

		// 파란공이 들어갔을 때
		if(blueIn)
			return;

		// 최소 값을 찾았고 현재 depth가 최솟값보다 크면 컷
		if (result != 0 && idx >= result) {
			return;
		}

		// 구슬을 넣었으면 종료
		if (redIn && !blueIn) {
			result = idx;
//			System.out.println(result);
			return;
		}

		// 10 번 넘었으면 되돌리기
		if (idx == 10) {
			return;
		}
		

		// 4방향 돌기
		for (int d = 0 ; d < 4 ; d ++) {
			redIn = false;
			blueIn = false;
			
			// map 복사
			char[][] copyMap = new char[n][m];

			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j ++) {
					copyMap[i][j] = map[i][j];
				}
			}

			int[] copyRx = rx.clone();
			int[] copyRy = ry.clone();
			// map 복사 끝
			
			
			int tx, ty;
			int curx, cury;

			// 빨간공 파란공 두 개 돌기
			for (int t = 0 ; t < 2 ; t ++) {
				// 시작 벽 위치 구하기
				if ( d < 2 ) {
					// 왼쪽으로 기울이면
					if( d == 0 ) {
						curx = copyRx[t];
						cury = 0;
					}
					// 오른쪽으로 기울이면
					else {
						curx = copyRx[t];
						cury = m-1;
					}
				} else {
					// 위으로 기울이면
					if( d == 2 ) {
						curx = 0;
						cury = copyRy[t];
					}
					// 아래쪽으로 기울이면
					else {
						curx = n-1;
						cury = copyRy[t];
					}
				}

				// tx ty = 벽이나 구멍이 있는 자리
				tx = curx;
				ty = cury;

				curx += dx[d];
				cury += dy[d];

				while(inRange(curx, cury)) {

					if (copyMap[curx][cury] == '#' || copyMap[curx][cury] == 'O') {
						tx = curx;
						ty = cury;
					}

					// 옮겨야 할 구슬을 찾았으면
					if (copyMap[curx][cury] == 'R' || copyMap[curx][cury] == 'B' ) {

						if (copyMap[tx][ty] == 'O') {
							if (copyMap[curx][cury] == 'R') {
								redIn = true;
							} else {
								blueIn = true;
							}

							copyMap[curx][cury] = '.';

						} else {
							
//							System.out.println("=================== d2 before =================");
//							for (int i = 0 ; i < n ; i ++) {
//								for (int j = 0 ; j < m ; j ++) {
//									System.out.print(copyMap[i][j] + " ");
//								}
//								System.out.println();
//							}

							char temp = copyMap[tx+dx[d]][ty+dy[d]];
							copyMap[tx+dx[d]][ty+dy[d]] = copyMap[curx][cury];
							copyMap[curx][cury] = temp;
							
							tx += dx[d];
							ty += dy[d];

//							System.out.println("=================== d2 after =================");
//							for (int i = 0 ; i < n ; i ++) {
//								for (int j = 0 ; j < m ; j ++) {
//									System.out.print(copyMap[i][j] + " ");
//								}
//								System.out.println();
//							}
						}
					}

					curx += dx[d];
					cury += dy[d];
				}

			}

			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j++) {
					if (copyMap[i][j] == 'R') {
						copyRx[0] = i;
						copyRy[0] = j;
					} else if ( copyMap[i][j] == 'B' ) {
						copyRx[1] = i;
						copyRy[1] = j;
					}
				}
			}

//			 idx == 1 && rx[0] == 2 && ry[0] == 1
//						if (true) {				
//							System.out.printf("===================== %d =================== d : %d \n", idx , d);
//							
//							for (int i = 0 ; i < n ; i ++) {
//								for (int j = 0 ; j < m ; j ++) {
//									System.out.print(copyMap[i][j] + " ");
//								}
//								System.out.println();
//							}
//							System.out.println(" redIn : " + redIn + " " + blueIn);
//						}
//			
//						if (count == 15) {
//							System.exit(0);
//						}
//
//			count ++;
			
//			System.out.println("=================== copy RXY ================");
//			
//			System.out.println("rx : " + Arrays.toString(copyRx));
//			System.out.println("ry : " + Arrays.toString(copyRy));

			bt(idx + 1, copyMap, copyRx, copyRy, redIn, blueIn);

		}
	}

	static boolean inRange(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= m) ? false : true;
	}
}