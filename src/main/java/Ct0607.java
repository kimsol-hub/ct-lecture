import java.util.*;

public class Ct0607 {
    /**

     7. 좌표 정렬
     설명
     N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

     입력
     첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
     두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

     출력
     N개의 좌표를 정렬하여 출력하세요.

     예시 입력 1
     5
     2 7
     1 3
     1 2
     2 5
     3 6

     예시 출력 1
     1 2
     1 3
     2 5
     2 7
     3 6

     */
    public int[][] solution(int n, int[][] arr) {
        /* x,y좌표 정렬 */
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o1[0]-o2[0];
                }
            }
        });

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0;i<n;i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        Ct0607 main = new Ct0607();
        for (int[] x : main.solution(n, arr)) {
            System.out.println(x[0] + " " + x[1]);
        }

    }
}
