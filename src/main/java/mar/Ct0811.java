package mar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ct0811 {
    /**

     11. 미로의 최단거리 통로
     설명
     7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
     경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
     출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
     격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

     Image1.jpg

     위와 같은 경로가 최단 경로의 길이는 12이다.

     입력
     첫 번째 줄부터 7*7 격자의 정보가 주어집니다.

     출력
     첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.


     예시 입력 1
     0 0 0 0 0 0 0
     0 1 1 1 1 1 0
     0 0 0 1 0 0 0
     1 1 0 1 0 1 1
     1 1 0 1 0 0 0
     1 0 0 0 1 0 0
     1 0 1 0 0 0 0

     예시 출력 1
     12

     */

    static int[][] miro;
    static int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int BFS(int x, int y) {
        /* 기준 좌표의 동서남북 따져봐야 함 nx-1, ny | nx, ny-1 | nx+1, ny | nx, ny+1 */
        Queue<Integer[]> q = new LinkedList<>();
        int L=0;
        q.offer(new Integer[]{x,y});
        while (! q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                Integer[] point = q.poll();
                for (int j=0; j<4; j++) {
                    int nx = point[0] + directions[j][0];
                    int ny = point[1] + directions[j][1];
                    if (nx >= 0 && nx <= 6 && ny >=0&& ny<=6 && miro[nx][ny]==0 ) {
                        if (nx==6 && ny==6) return L+1;
                        miro[nx][ny]=1;
                        q.offer(new Integer[]{nx, ny});
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        miro = new int[7][7];
        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                miro[i][j] = kb.nextInt();
            }
        }
        Ct0811 main = new Ct0811();
        System.out.println(main.BFS(0, 0));
    }
}
