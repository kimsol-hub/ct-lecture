import java.util.*;

public class Ct0714 {
    /**

     14.
     그래프 최단거리(BFS)
     다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
     1 2 5
     3 4 6

     ▣ 입력설명
     첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
     결정보가 주어진다.

     ▣ 출력설명
     1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.

     ▣ 입력예제 1
     6 9
     1 3
     1 4
     2 1
     2 5
     3 4
     4 5
     4 6
     6 2
     6 5

     ▣ 출력예제 1
     2 : 3
     3 : 1
     4 : 1
     5 : 2
     6 : 2


     */
    static List<List<Integer>> list;
    static int[] ch;
    public int BFS(int target) {
        /* 최소 간선수 각각 출력 */
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (! q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size;i++) {
                int x = q.poll();
                if (x==target) return answer;
                if (ch[x]==0) {
                    ch[x] =1;
                    q.addAll(list.get(x));
                }
            }
            answer++;
        }
       return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        list = new ArrayList<>();
        ch = new int[n+1];
        for (int i =0;i<=n;i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i =0; i<m; i++) {
            int row =  kb.nextInt();
            int col = kb.nextInt();
            List<Integer> target = list.get(row);
            target.add(col);
        }
        Ct0714 main = new Ct0714();

        for (int i=2; i<=n; i++) {
            ch = new int[n+1];
            System.out.println(i + " : " + main.BFS(i));
        }
    }


}
