import java.util.Scanner;

public class Ct0804 {
    /**
     4. 중복순열 구하기 - 채점지원X
     1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
     하는 방법을 모두 출력합니다. >>DFS

     ▣ 입력설명
     첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.

     ▣ 출력설명
     첫 번째 줄에 결과를 출력합니다.
     출력순서는 사전순으로 오름차순으로 출력합니다.

     ▣ 입력예제 1
     3 2

     ▣ 출력예제 1
     1 1
     1 2
     1 3
     2 1
     2 2
     2 3
     3 1
     3 2
     3 3

     */
    static int n;
    static int m;
    static int[] answer;

    public void DFS(int cnt) {
        /* M개를 중복 허용해서 뽑는 모든 경우의 수 (순열) */
        if (cnt == m) {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i=1; i<=n; i++) {
                answer[cnt] = i;
                DFS(cnt+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        answer = new int[m];
        Ct0804 main = new Ct0804();
        main.DFS(0);

    }
}
