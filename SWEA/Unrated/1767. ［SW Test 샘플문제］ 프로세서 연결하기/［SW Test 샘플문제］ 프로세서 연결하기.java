import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, n, result = Integer.MAX_VALUE;
    static int[][] Map;
    static ArrayList<Node> cores;
    static boolean[] selected;
    static int[] dir;
    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {1, -1, 0 ,0};
    static int maxCores;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T ; t ++) {
            n = Integer.parseInt(br.readLine());

            Map = new int[n][n];
            cores = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    if (Map[i][j] == 1) {
                    	if ((i == n-1 || j == n-1 || i == 0 || j == 0) && Map[i][j] == 1)
                    		continue;
                        cores.add(new Node(i, j));
                    }
                }
            }
            selected = new boolean[cores.size()];
            dir = new int[cores.size()];

            dfs(0, 0);

            System.out.printf("#%d %d\n", t+1, result);
            result = Integer.MAX_VALUE;
            maxCores = 0;
            result = Integer.MAX_VALUE;
        }
    }

    static void dfs(int cnt, int curCores) {
    	if (curCores + (cores.size() - cnt) < maxCores) return;
    	
//    	if (result != Integer.MAX_VALUE && curCores != maxCores)
//    		return;
    	
        if (cnt == cores.size()) {
            int obs = 0;
            // 코어의 방향을 다 정했을 때
            for (int i = 0 ; i < n ; i ++ ) {
                for (int j = 0; j < n; j++) {
                    if (Map[i][j] == 2)
                        obs++;
                }
            }
            
            if (maxCores < curCores) {
            	maxCores = curCores;
            	result = obs;
            } else if (maxCores == curCores) {
            	if (result > obs) {
            		result = obs;
            	}
            }
            return;
        }
        
        Node cur = cores.get(cnt);

        // 코어의 방향을 정하는데 만약 선이 겹쳐진다면 안됨 ( 가지치기 )
        for (int i = 0 ; i < 4; i ++ ) {
            int cx = cur.x;
            int cy = cur.y;

            int nx = cx;
            int ny = cy;

            // 해당 방향으로 전선을 깔 수 있는지 확인용 boolean
            boolean can_go = true;

            // 해당 방향으로 현재 좌표에서 전선을 깔 수 있으면
            while(true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                if (!inRange(nx , ny)) break;

                if (Map[nx][ny] == 1 || Map[nx][ny] == 2) {
                    can_go = false;
                    break;
                }
            }

            // 전선을 못깔면
            if (!can_go)
                continue;

            
            // 전선을 깔 수 있으면 깔 거니까 현재 맵 상태를 저장함.
            int[][]copyMap = new int[n][n];
            // 맵 복사
            for (int a = 0 ; a < n ; a++) {
                for (int b = 0; b < n; b++) {
                    copyMap[a][b] = Map[a][b];
                }
            }

            nx = cx;
            ny = cy;
            
            // nx,ny 가 범위 안이라면 전선 깔기
            while(true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                if (!inRange(nx , ny)) break;

                Map[nx][ny] = 2;
            }
            
            // 현재 위치에서 해당 방향으로 전선을 깔 수 있어서 맵을 복사하고 전선을 깔았음.
            dfs(cnt + 1, curCores+1);

            // 맵 복구
            for (int a = 0 ; a < n ; a++) {
                for (int b = 0; b < n; b++) {
                    Map[a][b] = copyMap[a][b];
                }
            }
        }
        
        
        // 해당 코어를 사용하지 않고 다음 코어로 넘어감.
        dfs(cnt + 1, curCores);
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return false;
        }
        return true;
    }
}
