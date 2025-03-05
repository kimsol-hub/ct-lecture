
import java.util.Scanner;

public class Ct0708 {
    /**

     8. 송아지 찾기(BFS : 상태트리탐색)
     현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아
     지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음
     과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
     현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수
     있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
     하세요.

     ▣ 입력설명
     첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000
     까지이다.
     ▣ 출력설명
     점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

     ▣ 입력예제 1
     5 14
     ▣ 출력예제 1
     3

     ▣ 입력예제 2
     8 3
     ▣ 출력예제 2
     5

     */
    public int solution(int s, int e) {
        /* 점프 최소 횟수 구하기 일직선상 존재, 앞1, 뒤1, 앞5 이동 가능
        * 원하는 최종합 e-s
        * +1, -1, +5 를 최소로 조합해서 구해야 함
        * */
        int dif = e-s, answer = 0;

        while (dif != 0) {
            if (dif > 5) {
                answer += dif/5;
                dif = dif%5;
            }
            if (dif < 0) {
                answer -= dif;
                dif = 0;
            } else if (dif <= 3) {
                answer += dif;
                dif =0;
            } else {
                answer ++;
                int x = dif - 5;
                answer -=x;
                dif = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();

        Ct0708 main = new Ct0708();
        System.out.println(main.solution(s, e));
    }


}
