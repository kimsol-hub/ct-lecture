import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ct0609 {
    /**

     9. 뮤직비디오(결정알고리즘)
     설명
     지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
     DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
     순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
     1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
     지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
     고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
     그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.

     입력
     첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
     다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
     부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.

     출력
     첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.

     예시 입력 1
     9 3
     1 2 3 4 5 6 7 8 9

     예시 출력 1 (( 1 2 3 4 5 / 6 7 / 8 9
     17

     */
    public int solution(int n, int m, int[] arr) {
        /* 결정알고리즘 m개로 쪼갰을 때 최대한 비슷하면서 최적값 찾기
        *   분기점 M-1개 존재
            초기 분기점 >> /M 한 개수

            1 2 3 4 5 / 6 7 / 8 9

            총합 구한 다음 /m >>
            1 ~ 10
            15 13 17 45네..
            n*n+1 /2

            45/3 15

            15에 가깝게 다 잘라
            1 2 3 4 5

            6 7
            8 9
        *
        * */
        int answer = 0;
        List<Integer> idxList = new ArrayList<>();
        /**/



        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = kb.nextInt();
        }
        Ct0609 main = new Ct0609();
        System.out.println(main.solution(n, m, arr));
    }
}
