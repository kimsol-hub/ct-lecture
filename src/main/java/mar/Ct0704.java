package mar;

import java.util.Scanner;

public class Ct0704 {
    /**

     4. 피보나치 수열
     1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는
     수열이다.
     2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면
     된다.
     ▣ 입력설명
     첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
     ▣ 출력설명
     첫 줄에 피보나치 수열을 출력합니다.
     ▣ 입력예제 1
     10
     ▣ 출력예제 1
     1 1 2 3 5 8 13 21 34 55

     */
    static int[] fibo;
    public int DFS(int n) {
        if (fibo[n]>0) return fibo[n];
        if (n==1 || n==2) return fibo[n]=1;
        return fibo[n]=DFS(n-2) + DFS(n-1);
    }

    public void solution(int n) {
        /* 피보나치수열 구하기 */
        for (int i=1;i<=n;i++) {
            System.out.print(DFS(i)+ " ");
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        Ct0704 main = new Ct0704();
        main.solution(n);
    }
}
