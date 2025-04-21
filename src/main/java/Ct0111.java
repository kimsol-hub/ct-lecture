import java.util.Arrays;
import java.util.Scanner;

public class Ct0111 {
    /**
     11. 문자열 압축
     설명
     알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     단 반복횟수가 1인 경우 생략합니다.

     입력
     첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

     출력
     첫 줄에 압축된 문자열을 출력한다.

     예시 입력 1
     KKHSSSSSSSE

     예시 출력 1
     K2HS7E

     예시 입력2
     KSTTTSEEKFKKKDJJGG

     예시 출력 2
     KST3SE2KFK3DJ2G2

     */



    public String solution(String s) {
        /* 연속되는 문자의 경우 숫자로 요약 표현
        *  맨마지막과 비교를 위해 " " 추가
        *  */
        String answer = "";
        s += " ";
        int cnt = 1;
        char tmp = s.charAt(0);
        for (int i=0; i<s.length()-1; i++) {
            if (tmp != s.charAt(i+1)) {
                answer += tmp;
                if (cnt > 1) answer += cnt;
                tmp = s.charAt(i+1);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct0111 main = new Ct0111();
        String s = kb.nextLine().replace("\n", "");
        System.out.println(main.solution(s));
    }
}
