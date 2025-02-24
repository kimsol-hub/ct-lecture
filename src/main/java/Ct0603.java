import java.util.Scanner;

public class Ct0603 {
    /**
     3. 삽입 정렬
     설명
     N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     정렬하는 방법은 삽입정렬입니다.

     입력
     첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

     출력
     오름차순으로 정렬된 수열을 출력합니다.

     예시 입력 1
     6
     11 7 5 6 10 9

     예시 출력 1
     5 6 7 9 10 11

     */
    public int[] solution(int n, int[] arr) {
        /* 두번째 자리부터 앞을 탐색 앞자리가 더 크면 오른쪽으로 해당 값 밈 */
        int lt = 1;
        while (lt<n) {
            int target = arr[lt], lastIdx = lt;
            for (int i = lt-1;i>=0;i--) {
                if (target < arr[i]) {
                    lastIdx = i;
                    arr[i+1]= arr[i];
                } else break;

            }
            arr[lastIdx]= target;
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
        Ct0603 main = new Ct0603();
        for (int x: main.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
