package feb;

import java.util.Scanner;

public class Ct0203 {
    /**
     *
     3. 가위 바위 보
     설명
     A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
     가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
     예를 들어 N=5이면
     Image1.jpg
     두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

     입력
     첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


     출력
     각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


     예시 입력 1
     5
     2 3 3 1 3
     1 1 2 2 3

     예시 출력 1
     A
     B
     A
     B
     D
     */
    public String solution(int[] arrA, int[] arrB, int n) {
        /*1:가위, 2:바위, 3:보
        * 1 > 3 : 1이 이김
        * 1 < 2 : 2가 이김
        * 2 < 3 : 3이 이김
        *
        * 1 기준에서 1-3 > 음수, 이김  (-2)   1-2 > 양수, 짐(-1)
        * 2 기준에서 2-3 > 음수, 짐(-1)       2-1 > 양수, 이김(1)
        * 3 기준에서 3-1 > 양수, 짐(2)       3-2 > 양수, 이김(1)
        * */
        String answer = "";
        for (int i = 0 ; i<n;i++) {
            int result = arrA[i]-arrB[i];
            if (result == 0) {
                answer += "D\n";
            } else if (result == 1 || result == -2) {
                answer += "A\n";
            } else {
                answer += "B\n";
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i=0;i<n;i++) {
            arrA[i] = kb.nextInt();
        }
        for (int i=0;i<n;i++) {
            arrB[i] = kb.nextInt();
        }

        Ct0203 main = new Ct0203();
        System.out.println(main.solution(arrA, arrB, n));
    }
}
