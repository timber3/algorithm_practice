import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int arr[];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		arr = new int[t];
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		for (int i = 1 ; i <= t ; i ++) {
			queue.add(i);
		}
		
		while (queue.size() != 1) {
			queue.pollFirst();
			queue.addLast(queue.pollFirst());			
		}
		
		int result = queue.poll();
		
		System.out.println(result);

	}

}
