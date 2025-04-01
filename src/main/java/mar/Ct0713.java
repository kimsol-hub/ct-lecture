package mar;

import java.util.*;

public class Ct0713 {
    /**

     12. 경로 탐색(인접리스트)
     방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
     로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
     1 2 3 4 5
     1 2 5
     1 3 4 2 5
     1 3 4 5
     1 4 2 5
     1 4 5
     총 6 가지입니다.

     ▣ 입력설명
     첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
     결정보가 주어진다.

     ▣ 출력설명
     총 가지수를 출력한다.

     ▣ 입력예제 1
     5 9
     1 2
     1 3
     1 4
     2 1
     2 3
     2 5
     3 4
     4 2
     4 5

     ▣ 출력예제 1
     6

     */
    static int n;
    static List<List<Integer>> list;
    static int[] ch;
    static int answer;

    public void DFS(int now) {
        if (now == n) {
            answer++;
            return;
        }
        for (int i=0; i<list.get(now).size();i++) {
            int target = list.get(now).get(i);
            if (ch[target] ==0) {
                ch[target] = 1;
                DFS(target);
                ch[target] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        answer = 0;
        n = kb.nextInt();
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
        Ct0713 main = new Ct0713();
        ch[1] = 1;
        main.DFS(1);
        System.out.println(answer);
    }
}
