package org.example;

import java.util.Scanner;

public class Ct0108 {
    /**
     * 8. 유효한 팰린드롬
     * 설명
     * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
     * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
     * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
     * 알파벳 이외의 문자들의 무시합니다.
     *
     * 입력
     * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     *
     * 출력
     * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
     *
     *
     * 예시 입력 1
     * found7, time: study; Yduts; emit, 7Dnuof
     *
     * 예시 출력 1
     * YES
     */
    public String solution(String str) {
        /**
         * 공백없는 문자열, 대소문자 구분 안 함, 알파벳 외 문자 무시
         * 1. toCharArray
         * 2. lt, rt
         * 3. isAlphabet
         */
        String answer = "YES";

        int lt = 0, rt = str.length()-1;
        String smallStr = str.toLowerCase();
        char[] strArr = smallStr.toCharArray();

        while (lt < rt) {
            if (!Character.isAlphabetic(strArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(strArr[rt])) {
                rt--;
            } else {
                if (strArr[lt] != strArr[rt]) {
                    answer = "NO";
                    break;
                } else {
                    lt++;
                    rt--;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine().replace("\n", "");
        Ct0108 main = new Ct0108();

        System.out.println(main.solution(input));
    }
}
