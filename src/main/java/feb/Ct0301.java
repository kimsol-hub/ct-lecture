package feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ct0301 {
    /**
     * 1. 두 배열 합치기
     * 설명
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
     *
     *
     * 출력
     * 오름차순으로 정렬된 배열을 출력합니다.
     *
     *
     * 예시 입력 1
     * 3
     * 1 3 5
     * 5
     * 2 3 6 7 9
     *
     * 예시 출력 1
     * 1 2 3 3 5 6 7 9
     */
    public List<Integer> solution(int a, int b, int[] arrA, int[] arrB) {
        List<Integer> answer = new ArrayList<>();
        int idxA = 0;
        int idxB = 0;
        while (idxA<a && idxB < b) {
            if (arrA[idxA]<arrB[idxB]) answer.add(arrA[idxA++]);
            else answer.add(arrB[idxB++]);
        }
        while (idxA<a) {
            answer.add(arrA[idxA++]);
        }
        while (idxB<b) {
            answer.add(arrB[idxB++]);
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
        Ct0301 main = new Ct0301();
        for (int n : main.solution(a, b, arrA, arrB)) {
            System.out.print(n + " ");
        }
    }
}
