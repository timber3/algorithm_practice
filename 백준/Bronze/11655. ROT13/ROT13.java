import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			if((int)s.charAt(i) >=65) {
				if((int) s.charAt(i) <=90) {
					if((int)s.charAt(i) <=77) 
						sb.append((char)((int)s.charAt(i) +13) + "");
					else {
						sb.append((char)(((int)s.charAt(i) +13)%91 + 65) + "");
					}
				}
				else {
					if((int)s.charAt(i) <=109) {
						sb.append((char)((int)s.charAt(i) +13) + "");
					}
					else {
						sb.append((char)(((int)s.charAt(i) +13)%123 + 97) + "");
					}
				}
			}
			else {
				sb.append(s.charAt(i) + "");
			}
		}
		System.out.print(sb);
	}
}