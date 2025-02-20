import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ct0302 {
    /**
     *
     2. 공통원소 구하기
     설명
     A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


     입력
     첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
     두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
     네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     각 집합의 원소는 1,000,000,000이하의 자연수입니다.


     출력
     두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


     예시 입력 1
     5
     1 3 9 5 2
     5
     3 2 5 7 8

     예시 출력 1
     2 3 5

     */
    public List<Integer> solution(int a, int b, int[] arrA, int[] arrB) {
        int idxA = 0, idxB=0;
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        List<Integer> answer = new ArrayList<>();
        while (idxA < a && idxB < b) {
            if (arrA[idxA] > arrB[idxB]) {
                idxB++;
            } else if (arrA[idxA] < arrB[idxB]) {
                idxA++;
            } else {
                answer.add(arrA[idxA++]);
                idxB++;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int[] arrA = new int[a];
        for (int i = 0; i < a ; i++) {
            arrA[i] = kb.nextInt();
        }
        int b = kb.nextInt();
        int[] arrB = new int[b];
        for (int i = 0; i < b ; i++) {
            arrB[i] = kb.nextInt();
        }
        Ct0302 main = new Ct0302();
        for (int n : main.solution(a, b, arrA, arrB)) {
            if (n==0) continue;
            System.out.print(n + " ");
        }
    }
}
