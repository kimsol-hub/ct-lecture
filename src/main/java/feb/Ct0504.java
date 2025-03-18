package feb;

import java.util.Scanner;
import java.util.Stack;

public class Ct0504 {
    /**

     4. 후위식 연산(postfix)
     설명
     후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


     입력
     첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
     식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

     출력
     연산한 결과를 출력합니다.

     예시 입력 1
     352+*9-

     예시 출력 1
     12

     */
    public int solution(String s) {
        /*후위식계산 3*(5+2)-9 352+*9- 넣고 연산자 나오면 숫자 두 개 pop 계산 후 push*/
        int answer = 0;
        Stack<Integer> postfix = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.push(c-48);
            } else {
                if (c=='+') {
                    int rt = postfix.pop();
                    int lt = postfix.pop();
                    postfix.push(lt + rt);
                } else if (c=='-') {
                    int rt = postfix.pop();
                    int lt = postfix.pop();
                    postfix.push(lt - rt);
                } else if (c=='*') {
                    int rt = postfix.pop();
                    int lt = postfix.pop();
                    postfix.push(lt * rt);
                } else if (c=='/') {
                    int rt = postfix.pop();
                    int lt = postfix.pop();
                    postfix.push(lt / rt);
                }
            }
        }
        answer = postfix.pop();
        return answer;

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine().replace("\n", "");

        Ct0504 main = new Ct0504();
        System.out.println(main.solution(s));
    }
}
