import java.util.Arrays;
import java.util.Scanner;

public class Ct0610 {
    /**
     10. 마구간 정하기(결정알고리즘)
     설명
     N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
     현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
     가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
     C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

     입력
     첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
     둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

     출력
     첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

     예시 입력 1
     5 3
     1 2 8 4 9

     예시 출력 1
     3
     */
    public int solution(int n, int c, int[] arr) {
        /* 간격 최소값 lt, 최대값 rt
         * 최소값 중 최대값
         * 1. 차이가 mid일 정도로 두고 마굿간 cnt
         * 2. cnt 가 c 보다 크면 lt=mid+1
         * 3. cnt 가 c 보다 작으면 rt = mid-1
         * 4. cnt == c면 answer = diffMin, rt = mid-1
         * */
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = arr[n-1] - arr[0];

        while (lt <= rt) {
            int mid = (lt + rt)/2, diffMin = Integer.MAX_VALUE, diffTotal = 0, cnt = 1, start = arr[0];
            for (int i=1; i<n; i++) {
                diffTotal = arr[i]-start;
                if (diffTotal > mid) {
                    if (diffTotal < diffMin) diffMin = diffTotal;
                    start = arr[i];
                    cnt++;
                }
            }
            if (diffTotal < diffMin) diffMin = diffTotal;
            if (cnt>=c) {
                answer = Math.max(answer, diffMin);
                lt = mid+1;
            } else if (cnt < c) {
                rt = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Ct0610 main = new Ct0610();
        System.out.println(main.solution(n, c, arr));
    }
}
