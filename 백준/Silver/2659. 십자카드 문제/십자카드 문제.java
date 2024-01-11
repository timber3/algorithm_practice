import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int val = 0;

		val += 1000 * Integer.parseInt(st.nextToken());
		val += 100 * Integer.parseInt(st.nextToken());
		val += 10 * Integer.parseInt(st.nextToken());
		val += Integer.parseInt(st.nextToken());
		
		int val_clock = Clock(val);

		int count = 1;
		
		for(int i = 1111 ; i <= 9999 ; i ++) {
			if (val_clock > i) {
				if (!inZero(i)) {
					if (Clock(i) == i)
						count++;
				}
			} else
				break;
		}
		
		System.out.println(count);
	}

	static int Clock(int val) {

		int min = val;

		for (int i = 0; i < 4 ; i ++) {
			// 앞의 숫자를 맨 뒤로 땡기는 과정.
			int front = val/1000;
			val %= 1000;
			val *= 10;
			val += front;

			min = Math.min(val, min);
		}
		return min;
	}
	
	static boolean inZero(int i) {
		if (i/1000 == 0)
			return true;
		i %= 1000;
		if (i/100 == 0) 
			return true;
		i %= 100;
		if (i/10 == 0)
			return true;
		i %= 10;
		if (i == 0)
			return true;
		
		return false;
	}

}