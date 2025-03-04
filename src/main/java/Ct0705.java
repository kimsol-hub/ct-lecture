import java.util.Scanner;

public class Ct0705 {
    /**

     5. 이진트리 순회(깊이우선탐색)
     아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
     1
     2 3
     4 5 6 7
     전위순회 출력 : 1 2 4 5 3 6 7
     중위순회 출력 : 4 2 5 1 6 3 7
     후위순회 출력 : 4 5 2 6 7 3 1

     */
    public void solution(Node node) {
        /*
         * 1. 뿌리부터 출력
         * 2. 왼쪽으로 간 다음, 출력. 왼쪽이 존재하는지 확인.
         * 3. 없으면 오른쪽. 다음 올라오기. 올라온 다음 뿌리의 오른쪽 확인
         * 전위순회 뿌왼오*/
        printNode(node);
        System.out.println();
        /*
         * 1. 뿌리에서 왼쪽 먼저 확인.
         * 2. 왼쪽의 왼쪽 자식 존재여부 확인
         * 3. 맨밑으로 내려간 다음 왼쪽 출력
         * 4. 그 다음 뿌리 출력, 오른쪽 출력
         * 5. 그 위 뿌리로 올라가서 출력 후, 오른쪽 자식의 왼쪽 노드 존재 확인
         * 중위순회 왼뿌오*/
        printMidNode(node);
        System.out.println();

        /*
         * 1. 왼쪽 밑까지 탐색, 그 다음 오른쪽 출력
         * 2. 그 위 뿌리 탐색
         * 3. 뿌리의 오른쪽 먼저 탐색, 오른쪽의 왼쪽 확인.
         * 4. 왼쪽 맨 밑, 출력후 오른쪽 출력, 뿌리로 이동해서 뿌리 출력
         * 후위순회 왼오뿌*/
        printEndNode(node);
        System.out.println();

    }

    /*전위*/
    private void printNode(Node node) {
        System.out.print(node.getData() + " ");
        if (node.getLeft() != null) {
            printNode(node.getLeft());
        }
        if (node.getRight() != null) {
            printNode(node.getRight());
        }
    }

    /*왼뿌오*/
    private void printMidNode(Node node) {

        if (node.getLeft() != null) {
            printMidNode(node.getLeft());
        }
        System.out.print(node.getData() + " ");
        if (node.getRight() != null) {
            printMidNode(node.getRight());
        }
    }

    private void printEndNode(Node node) {

        if (node.getLeft() != null) {
            printEndNode(node.getLeft());
        }

        if (node.getRight() != null) {
            printEndNode(node.getRight());
        }
        System.out.print(node.getData() + " ");
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Node node = new Node(1, new Node(2), new Node(3));
        Node leftNode = node.getLeft();
        leftNode.setLeft(new Node(4));
        leftNode.setRight(new Node(5));

        Node rightNode = node.getRight();
        rightNode.setLeft(new Node(6));
        rightNode.setRight(new Node(7));

        Ct0705 main = new Ct0705();
        main.solution(node);
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
