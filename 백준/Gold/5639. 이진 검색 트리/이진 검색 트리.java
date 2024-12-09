import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public void addNode(int val) {

            // 큰 값이면 왼쪽으로
            if (this.val > val) {
                if (this.left != null) {
                    this.left.addNode(val);
                } else {
                    this.left = new Node(val);
                }
            }
            // 작은 값이면 오른쪽으로
            else if (this.val < val) {
                if (this.right != null) {
                    this.right.addNode(val);
                } else {
                    this.right = new Node(val);
                }
            }
        }

        public void printBackward() {
            if (this.left != null) {
                this.left.printBackward();
            }

            if (this.right != null) {
                this.right.printBackward();
            }

            System.out.println(this.val);
        }

    }

    public static void main(String[] args) throws Exception {

        Node root = null;
        // 루트 노드부터 탐색 후 left, right 순으로 탐색함 (전위탐색)
        while(true) {
            String str = br.readLine();
            if ("".equals(str) || str == null) {
                break;
            } else {
                int val = Integer.parseInt(str);
                // root 노드 생성
                if (root == null) {
                    root = new Node(val);
                } else {
                    root.addNode(val);
                }
            }
        }

        // 후위 순회 결과 출력
        root.printBackward();
    }
}