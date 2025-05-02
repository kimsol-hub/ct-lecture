package apr;

import java.util.*;

public class Ct0904 {
    /**
     4. 최대 수입 스케쥴
     현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강
     연을 해 주면 M만큼의 강연료를 주기로 했다.
     각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
     단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

     ▣ 입력설명
     첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과
     D(1<=D<=10,000)가 차례로 주어진다.

     ▣ 출력설명
     첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

     ▣ 입력예제 1
     6
     50 2
     20 1
     40 2
     60 3
     30 3
     30 1

     ▣ 출력예제 1
     150

     */

    static int n, max;
    static List<Talk> list;
    static class Talk implements Comparable<Talk> {
        int money;
        int day;

        public Talk(int money, int day) {
            this.money = money;
            this.day = day;
        }
        @Override
        public int compareTo(Talk t) {
            return t.day-this.day;
        }
    }

    public int solution() {
        /* d일 안에 와서 강연 해주면 m만큼의 돈 지불, 최대 강연비 반환
           가장 많은 돈을 주는 강연을 하면 됨.
           가장 많은 돈 >> 날짜 마감 빠른 순으로 나열
           날짜 가장 뒤에서부터 체크.
        *  */
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int j=0;
        for (int i=max; i>0; i--) {
            for (; j<n; j++) {
                Talk t = list.get(j);
                if (t.day>=i) {
                    pQ.offer(t.money);
                } else break;
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        max = Integer.MIN_VALUE;
        list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            list.add(new Talk(m, d));
            if (d > max) max = d;
        }
        Ct0904 main = new Ct0904();
        System.out.println(main.solution());
    }
}
