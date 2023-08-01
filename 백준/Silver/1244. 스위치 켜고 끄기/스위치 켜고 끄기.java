import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; // 스위치 개수
    static int arr[]; // 스위치 상태
    static int stu; // 학생 수
    static int gender[]; // 학생 성별
    static int number[]; // 학생이 받은 숫자.

    static void print_switch() {

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n+1];


        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stu = Integer.parseInt(br.readLine());

        gender = new int[stu];
        number = new int[stu];

        for (int i = 0 ; i < stu ; i ++) {
            st = new StringTokenizer(br.readLine());

            gender[i] = Integer.parseInt(st.nextToken());
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 입력 끝

        for (int i = 0; i < stu; i++) {
            // 남학생 이면 학생 숫자와 그 배수는 전부 뒤집는다.
            if (gender[i] == 1) {

                int cnt = 1;
                int multiple = (cnt * number[i]); // 남학생이 선택 되었을 때 바꾸어야 할 스위치의 인덱스

                // 인덱스가 스위치 개수 안이라면 다 바꿔줘야 함.
                while(multiple <= n) {
                    if (arr[multiple] == 0) arr[multiple] = 1;
                    else arr[multiple] = 0;

                    cnt ++;
                    multiple = (cnt * number[i]);
                }
            }
            // 여학생 이면 학생 숫자의 주변이 대칭인지 확인하고 대칭이면 뒤집 아니면 멈춤
            else {

                // 일단 여학생 번호부터 반대로 바꿔주기
                if (arr[number[i]] == 1) arr[number[i]] = 0;
                else arr[number[i]] = 1;


                int left = number[i] - 1; // 여학생 왼쪽 인덱스
                int right = number[i] + 1; // 여학생 오른쪽 인덱스


                // 왼쪽 오른쪽이 스위치 개수 범위 안이라면 반복하기
                while (right <= n && left > 0) {

                    // 만약 대칭이라면?
                    if (arr[left] == arr[right]) {

                        // 둘 다 바꿔주기
                        if (arr[left] == 1) {
                            arr[left] = 0;
                            arr[right] = 0;
                        } else {
                            arr[left] = 1;
                            arr[right] = 1;
                        }
                        // 바꾼 후 인덱스 옆으로 늘리기
                        right = right + 1;
                        left = left - 1;
                    }
                    // 만약 대칭이 아니라면?
                    else {
                        break; // 탈출
                    }
                }
            }
        }

        print_switch(); // 결과 출력
    }
}
