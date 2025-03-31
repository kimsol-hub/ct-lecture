import java.util.Arrays;
import java.util.Scanner;

public class Ct0901 {
    /**
     1. 씨름 선수
     현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습
     니다. 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
     현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
     “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은
     (크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
     N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는
     프로그램을 작성하세요.

     ▣ 입력설명
     첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.
     두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다. 각 선수의 키와 몸무게는 모두
     다릅니다.

     ▣ 출력설명
     첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.

     ▣ 입력예제 1
     5
     172 67
     183 65
     180 70
     170 72
     181 60

     ▣ 출력예제 1
     3

     */

    static int n;
    static Person[] arr;

    static class Person implements Comparable<Person> {
        int weight;
        int tall;

        @Override
        public int compareTo(Person o) {
            return this.tall - o.tall;
        }
        public Person(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
        }
    }

    public int solution() {
        /* 키, 몸무게 둘 다 높은 경우. 최다. 키 최저를 찾고 해당 몸무게보다 높은 경우 세기. 키 순으로 정렬 후 세기~ */
        int answer = 0;
        Arrays.sort(arr);

        for (int i=0; i<n; i++) {
            Person target = arr[i];
            boolean flag = true;

            for (int j=i+1; j<n; j++) {
                Person p = arr[j];
                if (target.weight < p.weight) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new Person[n];
        for (int i=0; i<n; i++) {
            int tall = kb.nextInt();
            int weight = kb.nextInt();
            arr[i] = new Person(weight, tall);
        }
        Ct0901 main = new Ct0901();
        System.out.println(main.solution());
    }
}
