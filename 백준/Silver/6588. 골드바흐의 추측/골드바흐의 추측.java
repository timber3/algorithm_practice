import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean [] bool = new boolean [1000001];
        Arrays.fill(bool,true);
        for(int i=3;i<1000000;i+=2) {
            if(!bool[i]) {
                continue;
            }
            int A = i;
            while((A+=i) <=1000000) {
                bool[A] = false;
            }
        }
        int N;
        while((N = Integer.parseInt(br.readLine())) !=0){
            for(int i = N-3;i>=N/2;i-=2) {
                if(bool[i] && bool[N-i]) {
                    sb.append(N + " = " + (N-i) + " + " + i + "\n");
                    break;
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}