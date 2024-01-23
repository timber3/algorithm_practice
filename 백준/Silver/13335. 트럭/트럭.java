import java.util.*;
import java.io.*;

public class Main {
    static int n, w, l, suml, cur;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        suml = 0;

        // 빈 공간을 미리 만들어 둔다.
        for (int i = 0 ; i < w ; i ++) {
            q.add(0);
        }

        st = new StringTokenizer(br.readLine());

        int truck = Integer.parseInt(st.nextToken());

        while(true) {
            cur++;
            suml -= q.poll();

            if(suml + truck <= l) {
                q.add(truck);

                suml += truck;

                if(--n == 0) break;

                truck = Integer.parseInt(st.nextToken());

            }else {
                q.add(0);
            }
        }

        cur += q.size(); //다리에 남아있는 트럭들 건너는 시간 합함
        System.out.println(cur);

    }
}