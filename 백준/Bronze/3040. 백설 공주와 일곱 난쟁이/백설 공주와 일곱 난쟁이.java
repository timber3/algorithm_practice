import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] mans = new int[9];
	static int[] v = new int[] {0, 0, 1, 1, 1, 1, 1, 1, 1};
	

	public static void main(String[] args) throws IOException {
		
		for (int i = 0 ; i < 9 ; i ++) {
			mans[i] = Integer.parseInt(br.readLine()); 
		}
		
		int sum = 0;
		
		do {
			
			for (int i = 0 ; i < 9 ; i ++) {
				if(v[i]== 1) {
					sum += mans[i];
				}
			}
			if (sum == 100) {
				for (int i = 0 ; i < 9 ; i ++) {
					if (v[i] == 1) {
						System.out.println(mans[i]);
					}
				}
			}
			sum = 0;
		} while(next_permutation());

	}
	
	static boolean next_permutation() {
		
		int i = v.length-1;
		
		while(i > 0 && v[i] <= v[i-1])
			i--;
		
		if (i == 0)
			return false;
		
		int j = v.length - 1;
		
		while(v[j] <= v[i-1])
			j--;
		
		int t = v[i-1];
		v[i-1] = v[j];
		v[j] = t;
		
		int k = v.length - 1;
		
		while(k > i) {
			t = v[k];
			v[k] = v[i];
			v[i] = t;
			k--;
			i++;
		}
		
		return true;
	}
	

}
