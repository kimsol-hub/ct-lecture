import java.util.*;

public class Ct0404 {
    /**
     *
     4. 모든 아나그램 찾기 (아나그램 구성이 같으면)
     설명
     S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

     입력
     첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
     S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

     출력
     S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

     예시 입력 1
     bacaAacba
     abc

     예시 출력 1
     3


     */
    public int solution(String s, String t) {
        /* s에서 t와 아나그램인 부분문자열 개수
        * 1. t 길이만큼 0부터 잘라내서 구성 비교
        * 2. 비교 방식, 처음에 구한 다음. 첫번째 거 빼주면서 -1, 0일경우 hash에서 제거
        * */
        int answer = 0;
        Map<Character, Integer> tAna = new HashMap<>();
        Map<Character, Integer> sAna = new HashMap<>();


        for (int i = 0;i<t.length();i++) {
            tAna.put(t.charAt(i), tAna.getOrDefault(t.charAt(i), 0)+1);
        }
        for (int i = 0;i<t.length()-1;i++) {
            sAna.put(s.charAt(i), sAna.getOrDefault(s.charAt(i), 0)+1);
        }

        int lt = 0;
        for (int rt=t.length()-1; rt<s.length();rt++) {
            sAna.put(s.charAt(rt), sAna.getOrDefault(s.charAt(rt), 0)+1);
            if (tAna.equals(sAna)) answer++;
            sAna.put(s.charAt(lt), sAna.get(s.charAt(lt))-1);

            if (sAna.get(s.charAt(lt)) == 0) sAna.remove(s.charAt(lt));
            lt++;
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine().replaceAll("\n", "");
        String t = kb.nextLine().replaceAll("\n", "");

        Ct0404 main = new Ct0404();

        System.out.print(main.solution(s, t));
    }
}
