package programmers;
import java.util.HashSet;

class 로또의_최고_순위와_최저_순위_Java_241005 {

    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> 당첨번호목록 = new HashSet<>();
        for (int num : win_nums) {
            당첨번호목록.add(num);
        }

        int 맞춘개수 = 0;
        int 알수없는번호개수 = 0;   // 0의 개수

        // 로또 번호 순회
        for (int num : lottos) {
            if (num == 0) {
                알수없는번호개수++;  // 0일 경우 알 수 없는 번호 개수 증가
            } else if (당첨번호목록.contains(num)) {
                맞춘개수++;  // 당첨 번호에 있는 경우 맞춘 개수 증가
            }
        }

        // 최고 순위: 맞춘 개수 + 0의 개수, 최저 순위: 맞춘 개수
        int 최고순위 = (맞춘개수 + 알수없는번호개수);
        int 최저순위 = (맞춘개수);

        return new int[] {최고순위, 최저순위};
    }

    private int 순위찾기(int 맞춘개수) {
        switch (맞춘개수) {
            case 6: return 1;  // 6개 맞추면 1등
            case 5: return 2;  // 5개 맞추면 2등
            case 4: return 3;  // 4개 맞추면 3등
            case 3: return 4;  // 3개 맞추면 4등
            case 2: return 5;  // 2개 맞추면 5등
            default: return 6; // 그 외는 6등 (낙첨)
        }
    }
}
