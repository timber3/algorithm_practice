import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, k;
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t ++ ) {
            map = new TreeMap<>();
            k = Integer.parseInt(br.readLine());

            for (int i = 0 ; i < k ; i ++) {
                st = new StringTokenizer(br.readLine());

                char order = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if (order == 'I') {
                    if (!map.containsKey(value)) {
                        map.put(value, 1);
                    } else {
                        map.put(value, map.get(value) + 1);
                    }
                } else {
                    if (map.isEmpty()) continue;
                    if (value == 1) {
                        int maxValue = map.lastKey();
                        int maxCount = map.get(maxValue);
                        if (maxCount == 1) {
                            map.remove(maxValue);
                        } else {
                            map.put(maxValue, maxCount - 1);
                        }
                    } else {
                        int minValue = map.firstKey();
                        int minCount = map.get(minValue);
                        if (minCount == 1) {
                            map.remove(minValue);
                        } else {
                            map.put(minValue, minCount - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
        }

        System.out.println(sb);
    }
}