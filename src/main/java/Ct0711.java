import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ct0711 {
    /**

     11. 그래프와 인접행렬

     각 그래프를 인접행렬로 어떻게 표현하는지 그림 참고.

     1. 무방향 그래프
     1 2 5
     3 4

     5 5
     1 2
     1 3
     2 4
     3 4
     2 5


     2. 방향그래프
     1 2 5
     3 4

     5 5
     1 2
     1 3
     3 4
     4 2
     2 5

     3. 가중치 방향그래프
     2 5
     1 2 5
     4 2
     3 4

     5 5
     1 2 2
     1 3 4
     3 4 5
     4 2 2
     2 5 5

     */
    private void noDirection(Scanner kb) {
        /* 무방향 */
        int n = kb.nextInt(); //노드 수
        int m = kb.nextInt(); //간선 수
        int[][] arr = new int[n+1][n+1];
        for (int i=0;i<m;i++) {
            int row = kb.nextInt();
            int col = kb.nextInt();
            arr[row][col] = 1;
            arr[col][row] = 1;
        }
        for (int i = 1; i<= m ;i++) {
            for (int j = 1;j<=m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void direction(Scanner kb) {
        /* 방향 */
        int n = kb.nextInt(); //노드 수
        int m = kb.nextInt(); //간선 수
        int[][] arr = new int[n+1][n+1];
        for (int i=0;i<m;i++) {
            int row = kb.nextInt();
            int col = kb.nextInt();
            arr[row][col] = 1;
        }
        for (int i = 1; i<= m ;i++) {
            for (int j = 1;j<=m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void directionAndWeight(Scanner kb) {
        /* 가중치 */
        int n = kb.nextInt(); //노드 수
        int m = kb.nextInt(); //간선 수
        int[][] arr = new int[n+1][n+1];
        for (int i=0;i<m;i++) {
            int row = kb.nextInt();
            int col = kb.nextInt();
            int weight = kb.nextInt();
            arr[row][col] = weight;
        }
        for (int i = 1; i<= m ;i++) {
            for (int j = 1;j<=m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Ct0711 main = new Ct0711();
        Scanner kb = new Scanner(System.in);

        main.noDirection(kb);
        main.direction(kb);
        main.directionAndWeight(kb);
    }
}
