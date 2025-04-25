import java.util.Scanner;

public class Ct0813 {
    /**
     08 13. 섬나라 아일랜드
     설명
     N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
     각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
     섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

     Image1.jpg
     만약 위와 같다면 섬의 개수는 5개입니다.

     입력
     첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
     두 번째 줄부터 격자판 정보가 주어진다.

     출력
     첫 번째 줄에 섬의 개수를 출력한다.

     예시 입력 1
     7
     1 1 0 0 0 1 0
     0 1 1 0 1 1 0
     0 1 0 0 0 0 0
     0 0 0 1 0 1 1
     1 1 0 1 1 0 0
     1 0 0 0 1 0 0
     1 0 1 0 1 0 0

     예시 출력 1
     5

     */

    static int[][] ch;
    static int[][] arr;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int n;



    public int solution() {
        /*
            아일랜드 지도 - arr, 섬은 상하좌우, 대각선으로 이루어짐. 이 때 섬의 총 개수 구하기
            dfs
            동서남북, 대각선 다 체크

        **/
        int answer = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (arr[i][j]==1 && ch[i][j]==0) {
                    ch[i][j]=1;
                    DFS(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }


    public void DFS(int x, int y) {
        for (int i=0; i<8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (arr[nx][ny]==1 && ch[nx][ny]==0) {
                ch[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Ct0813 main = new Ct0813();
        n = kb.nextInt();
        ch = new int[n+2][n+2];
        arr = new int[n+2][n+2];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(main.solution());
    }
}
