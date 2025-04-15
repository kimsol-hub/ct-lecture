import java.util.*;

class Quest implements Comparable<Quest> {
    int score;
    int time;
    int scorePerTime;
    int remain;


    public Quest(int score, int time) {
        this.score = score;
        this.time = time;
        this.scorePerTime = score/time;
        this.remain = score%time;
    }

    @Override
    public int compareTo(Quest q) {
        if (this.scorePerTime == q.scorePerTime) {
            if (this.remain == q.remain) {
                return q.time - this.time;
            }
            return q.remain - this.remain;
        }
        return q.scorePerTime - this.scorePerTime;
    }
}
public class Ct1006 {
    /**

     6. 최대점수 구하기(냅색 알고리즘)
     설명
     이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
     각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
     제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
     (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

     입력
     첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
     두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

     출력
     첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.


     예시 입력 1
     5 20
     10 5
     25 12
     15 8
     6 3
     7 4

     예시 출력 1
     41

     9 50
     12 7
     16 8
     20 10
     30 15
     10 5
     25 12
     15 8
     6 3
     7 4

     101

     */
    static int n, m;
    static List<Quest> list;


    public int solution() {
        /*
        * 제한시간 내 최대 점수 구하기
        * 시간당 점수 구해서 나열
        * */
        int answer = 0;

        Collections.sort(list);
        int target = m;
        for (Quest q : list) {
            if (target >= q.time) {
                answer += q.score;
                target -= q.time;
            }
            if (target == 0) break;
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct1006 main = new Ct1006();

        n = kb.nextInt();
        m = kb.nextInt();
        list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new Quest(kb.nextInt(), kb.nextInt()));
        }

        System.out.println(main.solution());
    }
}
