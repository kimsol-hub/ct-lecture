package feb;

import java.util.Scanner;

public class Ct0602 {
    /**
     2. 버블 정렬
     설명
     N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     정렬하는 방법은 버블정렬입니다.

     입력
     첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

     출력
     오름차순으로 정렬된 수열을 출력합니다.

     예시 입력 1
     6
     13 5 11 7 23 15

     예시 출력 1
     5 7 11 13 15 23

     */
    public int[] solution(int n, int[] arr) {
        /* 1,2 2,3 순차 탐색 및 크면 바꾸기, 마지막까지 바꾸면 끝 */
        for (int i=0;i<n-1;i++) {
            for (int j = 0;j<n-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = kb.nextInt();
        }
        Ct0602 main = new Ct0602();
        for (int x: main.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
