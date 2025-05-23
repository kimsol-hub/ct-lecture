package mar;

import java.util.*;

public class Ct0805 {
    /**
     5. 동전교환
     다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
     해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.

     ▣ 입력설명
     첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종
     류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
     각 동전의 종류는 100원을 넘지 않는다.

     ▣ 출력설명
     첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


     ▣ 입력예제 1
     3
     1 2 5
     15

     ▣ 출력예제 1
     3

     */
//    static int[] coins;
    static Integer[] coins;
    static int[] ch;
    static int m, answer = Integer.MAX_VALUE;

    public int BFS(int target) {
        /* 거스름돈 가장 적은 동전 개수로 반환 */
        ch = new int[501];
        int L = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int x = q.poll();
                for (int coin : coins) {
                    int nx = x+coin;
                    if (nx == target) return L+1;
                    if (ch[nx] ==0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public void DFS(int L, int total) {
        if (answer < L) return;
        if (total > m) return;
        if (total == m) {
            answer = Math.min(L, answer);
        }
        else {
            for (int x: coins) {
                DFS(L+1, total+x);
            }
        }
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
//        coins = new int[n];
//        for (int i=0; i<n; i++) {
//            coins[i] = kb.nextInt();
//        }
//        int m = kb.nextInt();
//
//        mar.Ct0805 main = new mar.Ct0805();
//        System.out.print(main.BFS(m));
        coins = new Integer[n];
        for (int i=0; i<n; i++) {
            coins[i] = kb.nextInt();
        }
        m = kb.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());
        Ct0805 main = new Ct0805();
        main.DFS(0, 0);
        System.out.print(answer);
    }
}
