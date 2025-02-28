
import java.util.Scanner;

public class Ct0701 {
    /**
     1. 재귀함수
     자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
     ▣ 입력설명
     첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
     ▣ 출력설명
     첫째 줄에 출력한다

     입력예제
     3

     출력예제
     1 2 3

     */
    public void solution(int n) {
        /* 1부터 n까지 출력, 재귀 사용 */
        if (n>1) solution(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Ct0701 main = new Ct0701();
        main.solution(n);
    }
}
