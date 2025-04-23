import java.util.Scanner;

public class Ct0306 {
    /**
     03 6. 최대 길이 연속부분수열
     설명
     0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
     1 1 0 0 1 1 0 1 1 0 1 1 0 1
     여러분이 만들 수 있는 1이 연속된 연속부분수열은

     Image1.jpg
     이며 그 길이는 8입니다.

     입력
     첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
     두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

     출력
     첫 줄에 최대 길이를 출력하세요.

     예시 입력 1
     14 2
     1 1 0 0 1 1 0 1 1 0 1 1 0 1

     예시 출력 1
     8

     */



    public int solution(int n, int k, int[] arr) {
        /* 0 k개는 무시하고 1 연속수열 길이
        lt =0, rt = n

        *  */
        int answer = 0;

        int lt = 0, rt = n;
        while (lt < rt) {
            int length=0;
            int cnt=0;
            for (int i=lt; i<rt; i++) {
                if (arr[i]==0) {
                    cnt++;
                    if (cnt>k) break;
                    length++;
                } else length++;
            }
            answer = Math.max(answer, length);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct0306 main = new Ct0306();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(main.solution(n, k, arr));
    }
}
