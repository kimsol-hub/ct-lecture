package feb;

import java.util.*;

public class Ct0208 {
    /**
     *
     8. 등수구하기
     설명
     N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
     같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
     즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


     입력
     첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


     출력
     입력된 순서대로 등수를 출력한다.


     예시 입력 1
     5
     87 89 92 100 76

     예시 출력 1
     4 3 2 1 5

     */
    public String solution(int n, int[] arr) {
        String answer = "";
        for (int i = 0;i<n;i++) {
            int tmp = 1;
            for (int j = 0 ; j<n;j++) {
                if (i==j) continue;
                if (arr[i]<arr[j]) tmp++;
            }
            answer += tmp + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = kb.nextInt();
        }
        Ct0208 main = new Ct0208();
        System.out.println(main.solution(n, arr));
    }
}
