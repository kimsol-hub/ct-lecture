import java.util.*;

class Coin {
    int cnt;
    int cash;

    public Coin(int cnt, int cash) {
        this.cnt = cnt;
        this.cash = cash;
    }
}
public class Ct1005 {
    /**

     5. 동전교환(냅색 알고리즘)
     설명
     다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     각 단위의 동전은 무한정 쓸 수 있다.

     입력
     첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
     두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
     각 동전의 종류는 100원을 넘지 않는다.

     출력
     첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


     예시 입력 1
     3
     1 2 5
     15

     예시 출력 1
     3


     5
     1 8 20 25 50
     129

     5

     */
    static int n, m;
    static int[] arr;


    public int solution() {
        /*
        * 동전개수 구하기
        * 순차적으로 동전 개수 따지기, + 최소값 queue에 넣기
        * */
        Queue<Coin> q = new LinkedList<>();
        q.add(new Coin(0, m));
        int answer = Integer.MAX_VALUE;
        while (! q.isEmpty()) {
            int[] tmp = new int[n];
            int min = Integer.MAX_VALUE;
            Coin target = q.poll();
            if (target.cash == 0 && answer > target.cnt) {
                answer = target.cnt;
            }
            for (int i=0; i<n; i++) {
                tmp[i] = target.cash/arr[i];
                if (tmp[i]!=0 && min > tmp[i]) {
                    min = tmp[i];
                }
            }
            for (int i=0; i<n; i++) {
                if (tmp[i]==min) {
                    q.offer(new Coin(target.cnt+tmp[i], target.cash%arr[i]));
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct1005 main = new Ct1005();

        n = kb.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt();
        System.out.println(main.solution());
    }
}
