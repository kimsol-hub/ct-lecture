import java.util.*;

public class Ct0903 {
    /**

     3. 결혼식
     현수는 다음 달에 결혼을 합니다.
     현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
     피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
     각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
     현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을
     수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
     만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는
     것이고 15시 정각에는 존재하지 않는다고 가정합니다.

     ▣ 입력설명
     첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
     두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
     시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가
     는 시간이 음이 아닌 정수로 표현됩니다.

     ▣ 출력설명
     첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.

     ▣ 입력예제 1
     5
     14 18
     12 15
     15 20
     20 30
     5 14

     ▣ 출력예제 1
     2

     ▣ 입력예제 2
     10
     17 28
     6 30
     1 27
     19 38
     4 46
     23 30
     35 43
     26 45
     21 31
     11 44

     ▣ 출력예제 2
     9

     */

    static int n;
    static List<TimeTable> list;
    static class TimeTable implements Comparable<TimeTable> {
        int time;
        char state;

        public TimeTable(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(TimeTable t) {
            if (this.time == t.time) return this.state - t.state;
            return this.time-t.time;
        }
    }

    public int solution() {
        /* 이건 기준을 처음 중간 끝 어느 곳도 잡을 수 없음. 그냥 시간대를 배열로 두고 해당되는 시간대 +1 해주기.
           >> 이것보다 간단한 방법..!! cnt -+ 해주기, 그리디는 가능한 for문 하나로!!
        *  */
        int answer = Integer.MIN_VALUE, cnt=0;
        Collections.sort(list);

        for (int i=0; i<list.size(); i++) {
            TimeTable t = list.get(i);
            if (t.state == 's') cnt++;
            else if (t.state == 'e') cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(new TimeTable(kb.nextInt(), 's'));
            list.add(new TimeTable(kb.nextInt(), 'e'));
        }
        Ct0903 main = new Ct0903();
        System.out.println(main.solution());
    }
}
