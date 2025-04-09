import java.util.*;
import java.io.*;

public class Main {
    static class Village implements Comparable<Village> {
        long x; // 위치
        long a; // 인구 수

        Village(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Village other) {
            return Long.compare(this.x, other.x); // 위치 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 마을 정보를 저장할 리스트
        ArrayList<Village> villages = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            villages.add(new Village(x, a));
        }

        // 위치 기준으로 정렬
        Collections.sort(villages);

        // 전체 인구 합 계산
        long totalPopulation = 0;
        for (Village v : villages) {
            totalPopulation += v.a;
        }

        // 왼쪽 인구 합 계산하며 중앙값 위치 찾기
        long leftPopulation = 0;
        for (Village v : villages) {
            leftPopulation += v.a;
            if (leftPopulation >= (totalPopulation + 1) / 2) { // 반올림 고려
                System.out.println(v.x);
                break;
            }
        }
    }
}