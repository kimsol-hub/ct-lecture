import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ct0706 {
    /**

     6. 부분집합 구하기(DFS)
     자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
     을 작성하세요.

     ▣ 입력설명
     첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
     ▣ 출력설명
     첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
     단 공집합은 출력하지 않습니다.

     ▣ 입력예제 1
     3
     ▣ 출력예제 1
     1 2 3
     1 2
     1 3
     1
     2 3
     2
     3

     */
    static int[] checkVal;
    static int n;

    private void DFS(int now) {
        if (now==n+1) {
            String answer = "";
            for (int i = 1; i<=n;i++) {
                if (checkVal[i]==1) answer += i + " ";
            }
            System.out.println(answer);
        }
        else {
            checkVal[now] = 1;
            DFS(now+1);
            checkVal[now] = 0;
            DFS(now+1);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        checkVal = new int[n+1];
        Ct0706 main = new Ct0706();
        main.DFS(1);
    }
}
