package org.example;

import java.util.Scanner;

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
    public String solution(String str) {
        /*
        * 1. 띄어쓰기 기준 split & toCharArray
        * 2. 떨어진 최소거리.. 각 target이 단어 어느 위치에 있는지 idx 확인
        * 3. idx 전이면 해당 idx 부터 체크, 이후면 그 다음 idx로 이동해서 이전 idx와 거리 비교 후 적용
        * */
        String answer = "";
        String[] strArr = str.split(" ");
        String word = strArr[0];
        char target = strArr[-1].charAt(0);
        char[] wordArr = word.toCharArray();



        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine().replaceAll("\n", "");
        Ct0110 main = new Ct0110();
        System.out.println(main.solution(input));
    }
}
