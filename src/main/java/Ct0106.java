import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ct0106 {
    /**
     * 6. 중복문자제거
     * 설명
     * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
     * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
     *
     * 입력
     * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
     *
     * 출력
     * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     *
     * 예시 입력 1
     * ksekkset
     *
     * 예시 출력 1
     * kset
     */
    public String solution(String str) {
        /**
         * 1. toCharArray
         * 2. Set에 넣어주기?
         * */
        String answer = "";
        Set<Character> duplicated = new HashSet<>();
        char[] strArr = str.toCharArray();
        for (char c : strArr) {
            if (!duplicated.contains(c)) {
                answer += c;
                duplicated.add(c);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        Ct0106 main = new Ct0106();

        System.out.println(main.solution(input));
    }
}
