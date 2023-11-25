import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		String s = br.readLine();
		String[] array = new String[s.length()];
		for(int i=0;i<s.length();i++) {
			array[i] = s.substring(i,s.length());
		}
		Arrays.sort(array);
		for(int i=0;i<s.length();i++) {
			System.out.println(array[i]);
		}
	}
}