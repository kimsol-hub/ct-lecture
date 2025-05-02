package apr;

import java.util.Scanner;

public class Ct1002 {
    /**

     2. 돌다리 건너기
     설명
     철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
     철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
     철수가 개울을 건너는 방법은 몇 가지일까요?

     입력
     첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.

     출력
     첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.


     예시 입력 1
     7

     예시 출력 1
     34

     */
    static int n;
    static int[] answer;


    public int solution() {
        /*
        * 한 번에 한 칸 혹은 두 칸
        * 개울, n개의 돌다리
        * */
        answer[1] = 1;
        answer[2] = 2;
        for (int i=3; i<=n+1; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer[n+1];
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct1002 main = new Ct1002();

        n = kb.nextInt();
        answer = new int[n+2];
        System.out.println(main.solution());
    }
}
