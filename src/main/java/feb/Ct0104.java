package feb;

import java.util.Arrays;
import java.util.Scanner;

public class Ct0104 {
    /**
     * 4. 단어 뒤집기
     * 설명
     * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
     *
     *
     * 출력
     * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     *
     *
     * 예시 입력 1
     * 3
     * good
     * Time
     * Big
     *
     * 예시 출력 1
     * doog
     * emiT
     * giB
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] arr = new String[n];
        for (int i = 0 ; i< n ; i++) {
            arr[i] = in.next();
        }
        String[] answer = new String[n];
        for (int i = 0; i< n ; i++) {
            answer[i] = "";
            char[] itemArr = arr[i].toCharArray();
            for (int j = 0; j < arr[i].length()/2 ;j++ ) {
                // 0 1 2 3 4 >> 0, 4 / 1, 3 / 2, 2 === 0 1 2
                char tmp = itemArr[j];
                int changeIdx = arr[i].length() - 1 - j;
                itemArr[j] = itemArr[changeIdx];
                itemArr[changeIdx] = tmp;
            }
            answer[i] = new String(itemArr);
        }
        System.out.println(String.join("\n", answer));
    }
}
