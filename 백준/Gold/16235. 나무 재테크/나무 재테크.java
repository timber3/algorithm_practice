import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, count;
    static PriorityQueue<Tree>[][] trees;
    static int[][] map;
    static int[][] potion;

    // 8방향
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    static class Tree {
        int age;
        boolean live;

        public Tree(int age, boolean live) {
            this.age = age;
            this.live = live;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        trees = new PriorityQueue[n][n];
        map = new int[n][n];
        potion = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {

            }
        }

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                potion[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
                trees[i][j] = new PriorityQueue<>((o1, o2) -> {
                    return o1.age - o2.age;
                });
            }
        }

        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            trees[x][y].add(new Tree(z, true));
        }

        // input

        for (int i = 0 ; i < k ; i++) {
            simul();
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j ++) {
                for (Tree t : trees[i][j]) {
                    if (t.live) count ++;
                }
            }
        }

        System.out.println(count);
    }

    static void simul() {
        springAndSummer();
        autumnAndWinter();
    }

    // 봄에는 나무의 나이만큼 양분을 먹는다. 어린 나무 먼저 먹고, 나이만큼 양분을 먹지 못하는 나무는 죽는다.
    // 여름에는 죽은 나무가 양분으로 변한다. 나이 / 2 만큼의 양분이 땅에 추가된다. ( 소수점은 버림 )
    static void springAndSummer() {
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                int sum = 0;
                ArrayDeque<Tree> temp = new ArrayDeque<>();
                while(!trees[i][j].isEmpty()) {
                    Tree cur = trees[i][j].poll();
                    if (map[i][j] >= cur.age) {
                        map[i][j] -= cur.age;
                        cur.age ++;
                        temp.add(cur);
                    } else {
                        sum += cur.age/2;
                    }
                }

                trees[i][j].addAll(temp);
                map[i][j] += sum;
            }
        }
    }

    // 가을에는 나무의 나이가 5의 배수이면 번식한다. 인접한 8개 칸에 1살짜리 나무가 생긴다.
    // 겨울에는 땅에 양분을 추가한다.
    static void autumnAndWinter() {
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                ArrayDeque<Tree> temp = new ArrayDeque<>();
                while(!trees[i][j].isEmpty()) {
                    Tree cur = trees[i][j].poll();
                    temp.add(cur);
                    if (cur.age % 5 == 0) {
                        for (int d = 0 ; d < 8 ; d ++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                            trees[nx][ny].add(new Tree(1, true));
                        }
                    }
                }

                trees[i][j].addAll(temp);
                map[i][j] += potion[i][j];
            }
        }
    }
}