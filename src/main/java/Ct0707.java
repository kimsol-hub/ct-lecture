import java.util.*;

public class Ct0707 {
    /**

     7. 이진트리 순회(넓이우선탐색 : 레벨탐색)
     아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
     1
     2 3
     4 5 6 7
     레벨 탐색 순회 출력 : 1 2 3 4 5 6 7

     */

    private void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 0;
        while (! q.isEmpty()) {
            int size = q.size();
            System.out.print(L + " : ");
            for (int i =0;i<size;i++) {
                Node n = q.poll();
                System.out.print(n.data + " ");
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            System.out.println();
            L++;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Ct0707 main = new Ct0707();
//        main.solution(node);
        main.BFS(node);
    }

    static class Node {
        int data;
        Node left,right;

        public Node(int i) {
            data = i;
            this.left = null;
            this.right = null;
        }
    }
}
