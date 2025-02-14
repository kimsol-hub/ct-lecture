package org.example;

import java.util.Scanner;

public class Ct0205 {
    /**
     * 5. 소수(에라토스테네스 체)
     * 설명
     * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
     * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
     *
     *
     * 입력
     * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     *
     * 출력
     * 첫 줄에 소수의 개수를 출력합니다.
     *
     *
     * 예시 입력 1
     * 20
     *
     * 예시 출력 1
     * 8
     */
    public int solution(int n) { /*자연수의 개수 N(2<=N<=200,000) 소수 -  자기자신과 1로만 나누어지는 수 (1 제외)*/
        /* 1. 짝수 거르기 (2로 나누어지는 수)
        * 2. 2,3,5,7
        * 4.
        * 5.
        * */
        int cnt = 0;
        int[] isPrime = new int[n+1];
        for (int i = 2 ; i <= n ; i++) {
            if (isPrime[i] == 0 ) {
                cnt++;
                for (int j = i*2 ; j<= n ; j += i) {
                    isPrime[j] = 1;
                }
            }

        }
        return cnt;
    }



    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        Ct0205 main = new Ct0205();
        System.out.println(main.solution(n));
    }
}
