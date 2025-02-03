package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Ct0105 {
    /**
     * 5. 특정 문자 뒤집기
     * 설명
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     *
     *
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     *
     * 예시 입력 1
     * a#b!GE*T@S
     *
     * 예시 출력 1
     * S#T!EG*b@a
     */
    public static void main(String[] args) { //65-90 97-122
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().replaceAll("\n", "");
        Boolean[] isNotChanged = new Boolean[str.length()];
        Arrays.fill(isNotChanged, true);

        char[] strArr = str.toCharArray();
        for (int i = 0; i<str.length();i++) {
            int n = (int) strArr[i];
            char tmp;
            if ((n >=65 && n <=90) || (n >=97 && n <=122)) {
                tmp = strArr[i];
            } else {
                isNotChanged[i] = false;
                continue;
            }
            for (int j = str.length()-1; j >= 0;j--) {
                if (!isNotChanged[j]) {
                    continue;
                }
                int m = (int) strArr[j];
                if ((m >=65 && m <=90) || (m >=97 && m <=122)) {
                    if ((isNotChanged[i] && isNotChanged[j])) {
                        strArr[i] = strArr[j];
                        strArr[j] = tmp;
                        isNotChanged[i] = false;
                        isNotChanged[j] = false;
                        break;
                    }
                } else {
                    isNotChanged[j] = false;
                }
            }
        }
        String answer = new String(strArr);
        System.out.println(answer);
    }
}
