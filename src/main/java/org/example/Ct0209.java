package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ct0209 {
    /**
     *
     9. 격자판 최대합
     설명
     5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     Image1.jpg
     N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


     입력
     첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


     출력
     최대합을 출력합니다.


     예시 입력 1
     5
     10 13 10 12 15
     12 39 30 23 11
     11 25 50 53 15
     19 27 29 37 27
     19 13 30 13 19

     예시 출력 1
     155

     */
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int rowTotal = 0;
        int diagonolTotal = 0;
        int reverseDiagonolTotal = 0;
        int columnTotal = 0;

        for (int i=0;i<n;i++) {
            diagonolTotal += arr[i][i];
            for (int j=0;j<n;j++) {
                rowTotal += arr[i][j];
                columnTotal += arr[j][i];
            }
            int max = Math.max(rowTotal, columnTotal);
            rowTotal = 0;
            columnTotal = 0;
            if (max > answer) {
                answer = max;
            }
        }
        for (int i=n-1;i>=0;i--) {
            reverseDiagonolTotal += arr[i][i];
        }

        int tmp = Math.max(diagonolTotal, reverseDiagonolTotal);
        if (tmp > answer) answer = tmp;

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0;i<n;i++) {
            for (int j = 0; j<n ;j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        Ct0209 main = new Ct0209();
        System.out.println(main.solution(n, arr));
    }
}
