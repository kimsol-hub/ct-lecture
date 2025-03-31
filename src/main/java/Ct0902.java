import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ct0902 {
    /**

     2. 회의실 배정
     한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들
     려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하
     면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중
     단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

     ▣ 입력설명
     첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정
     보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
     회의 시간은 0시부터 시작된다.
     회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.

     ▣ 출력설명
     첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

     ▣ 입력예제 1
     5
     1 4
     2 3
     3 5
     4 6
     5 7

     ▣ 출력예제 1
     3

     */

    static int n;
    static Meeting[] arr;
    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        @Override
        public int compareTo(Meeting o) {
            if (this.startTime == o.startTime) return this.endTime - o.endTime;
            return this.startTime - o.startTime;
        }
        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int BFS(int idx) {
        int L = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while(! q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int targetIdx = q.poll();
                for (int j=targetIdx+1; j<n; j++) {
                    if (arr[targetIdx].endTime <= arr[j].startTime) q.offer(j);
                }
            }
            L++;
        }
        return L;
    }
    public int solution() {
        /* 최대수의 회의~ */
        int answer = 0;
        Arrays.sort(arr);

        for (int i=0; i<n-answer; i++) {
            int cnt = BFS(i);
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new Meeting[n];
        for (int i=0; i<n; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            arr[i] = new Meeting(start, end);
        }
        Ct0902 main = new Ct0902();
        System.out.println(main.solution());
    }
}
