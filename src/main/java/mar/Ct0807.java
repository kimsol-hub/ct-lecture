package mar;

import java.util.Scanner;

public class Ct0807 {
    /**
     7. 조합의 경우수(메모이제이션)
     nCr = n! / {(n-r)! r!}
     로 계산합니다.
     하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여
     재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

     nCr = n-1 C r-1 + n-1 C r

     ▣ 입력설명
     첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다. 3 33 0

     ▣ 출력설명
     첫째 줄에 조합수를 출력합니다.


     ▣ 입력예제 1
     5 3

     ▣ 출력예제 1
     10

     ▣ 입력예제 2
     33 19

     ▣ 출력예제 2
     818809200

     */
    static int n, m;
    static int[][] memories = new int[35][35];

    public int DFS(int num, int r) {
        /* n개 중 m개 뽑는 조합 개수, 종료 시점 r=0, n==r >> 1임,
           이거 생각했는데 왜 적용을 못했는가 >> r==0은 생각 못해서..
        * (n-1)! (n-r)! (n-r-1)! r! (r-1)!
        * */
        if (memories[num][r] > 0) return memories[num][r];
        if (r==0 || num==r) {
            return 1;
        }
        else {
            return memories[num][r] = DFS(num-1, r-1) + DFS(num-1, r);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        Ct0807 main = new Ct0807();

        System.out.println(main.DFS(n, m));
    }
}
