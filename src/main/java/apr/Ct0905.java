package apr;

import java.util.*;

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

    static int[] dis;
    static int n;

    static List<List<Edge>> graph;

    static class Edge implements Comparable<Edge> {
        int vt;
        int cost;

        public Edge(int vt, int cost) {
            this.vt = vt;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost-e.cost;
        }
    }
    public void solution(int s) {
        /* 1에서 각 정점 방문하는 최소 비용 출력 불가능할 경우 impossible
           1. 1에서 출발.
           2. 0이상인 경우 해당 노드로 이동.
           3. 이동 후 더해서 해당 값 넣기.
           4. 없을 경우, 종료.

           ===
           다익스트라 알고리즘 개념
           1. 출발노드 설정 (방문1표시)
           2. 출발노드 기준 각 노드 최소 비용 저장
           3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드 선택 (방문1표시)
           4. 최소 비용 노드 선택 기준 각 노드 최소 비용과 기존 비용을 비교하여 최소 비용 갱신 << 이 부분을 우선순위 큐로 하는 듯?
           5. 3-4번 과정 반복

            위의 내용을 우선순위큐(힙) 사용해서 할 수 있대.. nlogn됨 원래는 n*n


        *  */
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[1] = 0;
        pQ.offer(new Edge(s, 0));

        while (!pQ.isEmpty()) {
            Edge t = pQ.poll();
            int now = t.vt;
            int nowWeight = t.cost;
            if (dis[now] < nowWeight) continue; //이부분 중요
            for (Edge e : graph.get(t.vt)) {
                if (dis[e.vt] > nowWeight + e.cost) {
                    dis[e.vt] = nowWeight + e.cost;
                    pQ.offer(new Edge(e.vt, dis[e.vt])); //해당 위치 잊지말기
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int m = kb.nextInt();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE); //초기화할 때 기억.
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int p = kb.nextInt();
            graph.get(a).add(new Edge(b, p));
        }
        Ct0905 main = new Ct0905();
        main.solution(1);
        for (int i=2; i<=n; i++) {
            if (dis[i]==Integer.MAX_VALUE) System.out.println(i + " : impossible" );
            else System.out.println(i + " : " + dis[i]);
        }
    }
}
