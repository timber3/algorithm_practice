import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Integer> map = new HashMap<>();
    static int count;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        while(true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) break;

            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
                list.add(str);
            }

            count ++;
        }
        
        Collections.sort(list);

        for (String str : list) {
            double value = (double) map.get(str) / count * 100;
            sb.append(String.format("%s %.4f\n", str, value));
        }

        System.out.print(sb);
    }
}