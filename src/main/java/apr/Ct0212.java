package apr;

import java.util.Scanner;

public class Ct0212 {
    /**
     12. 멘토링
     설명
     현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
     멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
     선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
     만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
     M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


     입력
     첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
     두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
     만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


     출력
     첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

     예시 입력 1
     4 3
     3 4 1 2
     4 3 2 1
     3 1 4 2

     예시 출력 1
     3

     출력설명
     (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.

     입력 이해를 못한 거였음
     3 4 1 2 >> 차례로 등수임 3번학생 1등 ~ 2번학생 4등
     4 3 2 1 >> 4번학생 1등 ~ 1번학생 4등

     */



    public int solution(int[][] score) {
        /* 멘토는 멘티 등수보다 무조건 다 앞
           멘토 멘티 짝 경우의 수 구하기
           score[학생번호0-3][시험0-2]
           학생 순차로 돌면서 자기보다 모든 등수 아래인 사람 체크

           >> 프로그래머스처럼 아예 입력 형태대로 받게 될 수 있으니 강의 참고해서 수정
        *  */
        int answer = 0;

        for (int i=1; i<=4; i++) {
            for (int j=1; j<=4; j++) {
                int cnt = 0;
                for (int k=0; k<score.length; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int l=0; l<score[k].length; l++) {
                        if (score[k][l]==i) pi = l;
                        if (score[k][l]==j) pj = l;
                    }
                    if (pi > pj) cnt++;
                }
                if (cnt == score.length) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct0212 main = new Ct0212();
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[][] score = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int student = kb.nextInt();
                score[i][j] = student;
            }
        }

        System.out.println(main.solution(score));
    }
}
