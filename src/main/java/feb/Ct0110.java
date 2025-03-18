package feb;

import java.util.*;

public class Ct0110 {
    /**
     * 10. 가장 짧은 문자거리
     * 설명
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     *
     * 입력
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     *
     * 출력
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     *
     *
     * 예시 입력 1
     * teachermode e
     *
     * 예시 출력 1
     * 1 0 1 2 1 0 1 2 2 1 0
     *
     */
    public int[] solution(String str) {
        /*
         * 1. 띄어쓰기 기준 split & toCharArray
         * 2. 왼쪽 것을 기준으로 계산, 오른쪽을 기준으로 계산
         * */
        String[] strArr = str.split(" ");
        String word = strArr[0];
        int[] answer = new int[word.length()];
        char target = strArr[1].charAt(0);

        int P = 1000;

        for (int i = 0 ; i< word.length() ; i++) {
            if (word.charAt(i) == target) {
                P=0;
            } else {
                P++;
            }
            answer[i] = P;
        }
        for (int i = word.length()-1 ; i>= 0 ; i--) {
            if (word.charAt(i) == target) {
                P=0;
            } else {
                answer[i] = Math.min(answer[i], ++P);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine().replaceAll("\n", "");
        Ct0110 main = new Ct0110();
        for (int n : main.solution(input)) {
            System.out.print(n + " ");
        }

    }
}
