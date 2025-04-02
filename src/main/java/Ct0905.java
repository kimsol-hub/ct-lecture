import java.util.Arrays;
import java.util.Scanner;

public class Ct0905 {
    /**

     5. 다익스트라 알고리즘
     아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
     그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
     2 5
     1 2 5
     12
     5
     4
     5
     2
     3 4 6
     5
     5

     ▣ 입력설명
     첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
     결정보와 거리비용이 주어진다.

     ▣ 출력설명
     1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.

     ▣ 입력예제 1 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
     6 9
     1 2 12
     1 3 4
     2 1 2
     2 3 5
     2 5 5
     3 4 5
     4 2 2
     4 5 5
     6 4 5

     ▣ 출력예제 1
     2 : 11
     3 : 4
     4 : 9
     5 : 14
     6 : impossible

     */

    static int[][] arr;
    static int[] answer;
    static int[] ch;
    static int n;
    public void DFS(int node) {
        for (int i=1; i<=n; i++) {
            if (arr[node][i]>0) {
                if (ch[i]==0) {
                    ch[i] = 1;
                    if (answer[i]==0) answer[i] = answer[node]+arr[node][i];
                    else answer[i] = Math.min(answer[i], answer[node]+arr[node][i]);
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public void solution() {
        /* 1에서 각 정점 방문하는 최소 비용 출력 불가능할 경우 impossible
           1. 1에서 출발.
           2. 0이상인 경우 해당 노드로 이동.
           3. 이동 후 더해서 해당 값 넣기.
           4. 없을 경우, 종료.
        *  */
        ch[1]=1;
        DFS(1);
        for (int i=2; i<=n; i++) {
            if (answer[i]==0) System.out.println(i + " : impossible" );
            else System.out.println(i + " : " + answer[i]);
        }


    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int m = kb.nextInt();
        answer = new int[n+1];
        ch = new int[n+1];
        arr = new int[n+1][n+1];

        for (int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int p = kb.nextInt();
            arr[a][b] = p;
        }
        Ct0905 main = new Ct0905();
        main.solution();
    }
}
