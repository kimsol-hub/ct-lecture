package apr;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int vt;
    int cost;

    public Edge(int vt, int cost) {
        this.vt = vt;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge c) {
        return this.cost - c.cost;
    }
}
public class Ct0908 {
    /**

     8. 원더랜드(최소스패닝트리 : 프림, PriorintyQueue)
     원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
     원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지
     도로는 폐쇄하려고 한다.
     아래의 그림은 그 한 예를 설명하는 그림이다.

     17
     15 15
     위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시
     를 연결하는 방법을 찾아낸 것이다.

     ▣ 입력설명
     첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다. 다음 E개의
     줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 도시와 B번
     도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

     ▣ 출력설명
     모든 도시를 연결하면서 드는 최소비용을 출려한다.

     ▣ 입력예제 1
     9 12
     1 2 12
     1 9 25
     2 3 10
     2 8 17
     2 9 8
     3 4 18
     3 7 55
     4 5 44
     5 6 60
     5 7 38
     7 8 35
     8 9 15

     ▣ 출력예제 1
     196

     */

    static int n;
    static int[] ch;
    static PriorityQueue<Edge> pQ;
    static List<List<Edge>> graph;


    public int solution() {
        /* 모든 도시를 연결하는 최소 비용 찾기
        *  */
        int answer = 0;
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();
            int a = e.vt;
            if (ch[a]==0) {
                ch[a] = 1;
                answer += e.cost;

                for (Edge f : graph.get(a)) {
                    int b = f.vt;
                    if (ch[b] == 0) {
                        pQ.offer(f);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int m = kb.nextInt();
        graph = new ArrayList<>();
        pQ = new PriorityQueue<>();

        ch = new int[n+1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        Ct0908 main = new Ct0908();
        System.out.println(main.solution());
    }
}
