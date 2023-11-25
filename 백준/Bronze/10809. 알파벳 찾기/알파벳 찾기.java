import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int [] alphabet = new int[26];
		for(int i=0;i<26;i++) {
			alphabet[i] = -1;
		}
		for(int i=0;i<s.length();i++) {
			if(alphabet[(int)s.charAt(i)-97]==-1)
			{
				alphabet[(int)s.charAt(i)-97] = i;	
			}
		}
		for(int i=0;i<26;i++) {
			sb.append(alphabet[i] + " ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}