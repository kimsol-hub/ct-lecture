
import java.util.Scanner;

public class Ct0709 {
    /**

     9. Tree 말단 노드까지의 가장 짧은 경로(DFS)
     아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
     구하는 프로그램을 작성하세요.
     각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
     길이로 하겠습니다.
     1
     2 3
     4 5
     가장 짧은 길이는 3번 노드까지의 길이인 1이다

     */
    public int DFS(Node n, int depth) {
        if (n.getLeft() == null || n.getRight() == null) {
            return depth;
        } else {
            int leftDepth = DFS(n.getLeft(), depth+1);
            int rightDepth =  DFS(n.getRight(), depth+1);
            return Math.min(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2), new Node(3));
        Node leftNode = node.getLeft();
        leftNode.setLeft(new Node(4));
        leftNode.setRight(new Node(5));
//        Node childLeftNode = leftNode.getLeft();
//        childLeftNode.setLeft(new Node(6));
//        childLeftNode.setRight(new Node(7));


        Ct0709 main = new Ct0709();
        System.out.println(main.DFS(node, 0));
    }

    static class Node {
        int data;
        Node left;
        Node right;


        public Node(int i) {
            data = i;
        }

        public Node(int i, Node left, Node right) {
            data = i;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }
    }
}
