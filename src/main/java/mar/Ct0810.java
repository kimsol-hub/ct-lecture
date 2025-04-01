package mar;

import java.util.Scanner;

public class Ct0810 {
    /**


     10. 미로탐색
     설명
     7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
     출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
     격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

     Image1.jpg

     위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.

     입력
     7*7 격자판의 정보가 주어집니다.

     출력
     첫 번째 줄에 경로의 가지수를 출력한다.


     예시 입력 1
     0 0 0 0 0 0 0
     0 1 1 1 1 1 0
     0 0 0 1 0 0 0
     1 1 0 1 0 1 1
     1 1 0 0 0 0 1
     1 1 0 1 1 0 0
     1 0 0 0 0 0 0

     예시 출력 1
     8

     */


    static int answer=0;
    static int[][] miro;
    static int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void DFS(int x, int y) {
        /* 기준 좌표의 동서남북 따져봐야 함 nx-1, ny | nx, ny-1 | nx+1, ny | nx, ny+1 */
        if (x==7 && y==7) answer++;
        else {
            for (int i=0; i<4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx >= 1 && nx <=7 && ny >= 1 && ny <=7 && miro[nx][ny]==0) {
                    miro[nx][ny] = 1;
                    DFS(nx, ny);
                    miro[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        miro = new int[8][8];
        for (int i=1; i<8; i++) {
            for (int j=1; j<8; j++) {
                miro[i][j] = kb.nextInt();
            }
        }
        Ct0810 main = new Ct0810();
        miro[1][1] = 1;
        main.DFS(1, 1);
        System.out.println(answer);
    }
}
