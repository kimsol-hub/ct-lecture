package mar;

import java.util.*;

public class Ct0808 {
    /**

     8. 수열 추측하기
     가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼
     의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다. 예를 들어 N이 4 이고 가장 윗 줄에
     3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.

     3 1 2 4
     4 3 6
     7 9
     16

     N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하
     시오. 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

     ▣ 입력설명
     첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다. N은 가장 윗줄에 있는 숫자의 개수를 의
     미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

     ▣ 출력설명
     첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다. 답이 존재
     하지 않는 경우는 입력으로 주어지지 않는다.


     ▣ 입력예제 1
     4 16

     ▣ 출력예제 1
     3 1 2 4

     */
    static int n, f;
    static int[] answer, b, ch;
    static int[][] cb = new int[35][35];
    static boolean flag=false;

    public void DFS(int cnt, int sum) {
        /* 같은 레벨 내에선 전부 다른 숫자로 가정, 답 여러 개일 경우, 사전순 맨앞 출력
        * 3레벨일 경우,  a b c d 순으로 숫자가 있을 경우, 최상단 숫자 = 3C0 *a + 3C1*b + 3C2*c + 3C3*d  << 이거를 강의 보고 알았음. 파스칼 삼각형 규칙이라고 함.
        *  */
        if (flag) return;
        if (cnt == n) {
            if (sum == f) {
                for (int x : answer) System.out.print(x+ " ");
                flag = true;
            }
        } else {
            for (int i=1; i<=n; i++) {
                if (ch[i]==0) {
                    ch[i] = 1;
                    answer[cnt] = i;
                    DFS(cnt+1, sum + b[cnt]*answer[cnt]);
                    ch[i] = 0;
                }
            }
        }
    }

    public int getCombination(int n, int r) {
        if (cb[n][r] > 0) return cb[n][r];
        if (n==r || r==0) return 1;
        else return cb[n][r] = getCombination(n-1, r-1) + getCombination(n-1, r);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        ch = new int[n+1];

        b = new int[n];

        answer = new int[n];
        Ct0808 main = new Ct0808();

        for (int i=0; i<n; i++) {
            b[i] = main.getCombination(n-1, i);
        }
        main.DFS(0, 0);

    }
}
