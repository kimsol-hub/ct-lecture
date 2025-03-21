
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
        if (n.left == null && n.right == null) {
            return depth;
        } else {
            return Math.min(DFS(n.left, depth+1), DFS(n.right, depth+1));
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        Ct0709 main = new Ct0709();
        System.out.println(main.DFS(node, 0));
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
