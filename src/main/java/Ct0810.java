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
    static int[][] ch, miro;
    static int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void DFS(int x, int y) {
        /* 기준 좌표의 동서남북 따져봐야 함 nx-1, ny | nx, ny-1 | nx+1, ny | nx, ny+1 */
        if (x>6 || y>6) return;
        if (x==6 && y==6) answer++;
        else {
            for (int i=0; i<4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if (nx >= 0 && nx <=6 && ny >= 0 && ny <=6 && miro[nx][ny]==0 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny);
                    ch[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        miro = new int[7][7];
        ch = new int[7][7];
        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                miro[i][j] = kb.nextInt();
            }
        }
        Ct0810 main = new Ct0810();
        ch[0][0] = 1;
        main.DFS(0, 0);
        System.out.println(answer);
    }
}
