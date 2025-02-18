import java.util.Arrays;
import java.util.Scanner;

public class Ct0102 {
    /**
     * 2. 대소문자 변환
     * 설명
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     *
     * 입력
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * 출력
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     *
     *
     * 예시 입력 1
     * StuDY
     * 예시 출력 1
     * sTUdy
     * 65-90 대문자
     * 97-122 소문자
     */
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        String answer = "";
        char[] inputArr = input.toCharArray();
        for (int i = 0 ; i< inputArr.length ; i++) {
            if ((int) inputArr[i] >= 65 && (int) inputArr[i] <= 90) {
                answer += (char) ((int)inputArr[i]+32);
            } else if ((int) inputArr[i] >= 97 && (int) inputArr[i] <= 122) {
                answer += (char) ((int)inputArr[i]-32);
            }
        }

        System.out.println(answer);
        return ;
    }
}
