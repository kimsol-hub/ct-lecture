import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ct0707 {
    /**

     7. 이진트리 순회(넓이우선탐색 : 레벨탐색)
     아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
     1
     2 3
     4 5 6 7
     레벨 탐색 순회 출력 : 1 2 3 4 5 6 7

     */
    public void solution(Node node) {
        List<Node> parent = new ArrayList<>();
        parent.add(node);
        levelPrint(parent);
    }

    private void levelPrint(List<Node> nodeList) {
        List<Node> children = new ArrayList<>();
        for (Node node : nodeList) {
            System.out.print(node.getData() + " ");

            if (node.getLeft() != null) {
                children.add(node.getLeft());
            }
            if (node.getRight() != null) {
                children.add(node.getRight());
            }
        }
        if (children.size()>0) {
            levelPrint(children);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2), new Node(3));
        Node leftNode = node.getLeft();
        leftNode.setLeft(new Node(4));
        leftNode.setRight(new Node(5));

        Node rightNode = node.getRight();
        rightNode.setLeft(new Node(6));
        rightNode.setRight(new Node(7));

        Ct0707 main = new Ct0707();
        main.solution(node);
    }

    static class Node {
        int data;
        Node left;
        Node right;


        public Node(int i) {
            data = i;
        }

        public Node(int i,Node left, Node right) {
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
