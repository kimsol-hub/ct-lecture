import java.util.Scanner;

public class Ct0206 {
    /**
     * 6. 뒤집은 소수
     * 설명
     * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
     * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
     * 첫 자리부터의 연속된 0은 무시한다.
     *
     *
     * 입력
     * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
     * 각 자연수의 크기는 100,000를 넘지 않는다.
     *
     *
     * 출력
     * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
     *
     *
     * 예시 입력 1
     * 9
     * 32 55 62 20 250 370 200 30 100
     *
     * 예시 출력 1
     * 23 2 73 2 3
     */
    public String solution(int n, int[] arr) { /*뒤집어서 소수*/
        /*
         * */
        String answer = "";

        for (int i=0;i<n;i++) {
            String target = new StringBuilder(String.valueOf(arr[i])).reverse().toString();
            int tmp = Integer.parseInt(target);
            if (isPrime(tmp)) {
                answer += tmp + " ";
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        if (n<2) return false;
        for (int i=2;i*i<=n;i++) {
            if (n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n;i++) {
            arr[i] = kb.nextInt();
        }
//        String str = kb.nextLine().replaceAll("\n", "");
        Ct0206 main = new Ct0206();
        System.out.println(main.solution(n, arr));
    }
}
