package mar;

import java.util.LinkedList;
import java.util.Queue;

public class Ct0710 {
    /**

     10. Tree 말단 노드까지의 가장 짧은 경로(BFS)
     아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
     구하는 프로그램을 작성하세요.
     각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
     길이로 하겠습니다.
     1
     2 3
     4 5
     가장 짧은 길이는 3번 노드까지의 길이인 1이다

     */
    public int solution(Node n) {
       int level = 0;
       Queue<Node> q = new LinkedList<>();
       q.offer(n);
       while (! q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i<size; i++) {
               Node node = q.poll();
               if (node.left == null && node.right == null) return level;
               if (node.left != null) q.offer(node.left);
               if (node.left != null) q.offer(node.right);
           }
           level++;
       }
       return level;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        Ct0710 main = new Ct0710();
        System.out.println(main.solution(node));
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int i) {
            data = i;
            left = right = null;
        }


    }
}
