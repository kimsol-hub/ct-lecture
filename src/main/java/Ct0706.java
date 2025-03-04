import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ct0706 {
    /**

     6. 부분집합 구하기(DFS)
     자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
     을 작성하세요.

     ▣ 입력설명
     첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
     ▣ 출력설명
     첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
     단 공집합은 출력하지 않습니다.

     ▣ 입력예제 1
     3
     ▣ 출력예제 1
     1 2 3
     1 2
     1 3
     1
     2 3
     2
     3

     */
    public void solution(int num) {
        int[] arr = new int[num];
        for (int i = 0;i<num;i++) {
            arr[i] = i+1;
        }
        for (int i = num; i>0;i--) {
            partSet(arr, i, 0, new ArrayList<Integer>());
        }

    }

    private void partSet(int[] arr, int partCnt, int now, List<Integer> answer) {
        for (int i = now;i<arr.length;i++) {
            answer.add(arr[i]);
            now++;
            if (partCnt == answer.size()) {
                for (int j = 0; j<answer.size();j++) {
                    System.out.print(answer.get(j) + " ");
                }
                System.out.println();
            }
            partSet(arr, partCnt, now, answer);
            answer.remove(Integer.valueOf(arr[i]));

        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        Ct0706 main = new Ct0706();
        main.solution(n);
    }
}
