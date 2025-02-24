
import java.util.Scanner;

public class Ct0601 {
    /**
     1. 선택 정렬
     설명
     N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     정렬하는 방법은 선택정렬입니다.

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
        /* 최소값 탐색 후 순차적으로 변경*/
        int lt = 0;
        while (lt < n) {
            int min = arr[lt], idx = lt;
            for (int i = lt+1 ; i<n ; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    idx = i;
                }
            }
            int tmp = arr[lt];
            arr[lt] = arr[idx];
            arr[idx] = tmp;
            lt++;
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
        Ct0601 main = new Ct0601();
        for (int x: main.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
