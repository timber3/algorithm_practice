import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<>();
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		for (int i = 0 ; i < n ; i ++) {
			q.add(i+1); 
		}
		
		sb.append("<");
		
		while(!q.isEmpty()) {
			
			for (int i = 0 ; i < k-1 ; i ++) {
				q.add(q.poll());
			}
			if (q.size() != 1)
				sb.append(q.poll()+", ");
			else
				sb.append(q.poll() + ">");
		}
		
		System.out.println(sb.toString());
		


	}

}
