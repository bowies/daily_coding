package programmers;

import java.util.*;

class 요격_시스템_230529 {

    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparing((int[] i) -> i[1]));
        //targets 배열을 두번째 열(좌표 범위 끝) 기준으로 오름차순 정렬

        int 요격미사일수 = 0;
        int 현재요격가능한최대x좌표 = 0;

        for (int[] target : targets) {
            //targets 배열을 순회하며 요격 미사일 수 계산

            if (target[0] >= 현재요격가능한최대x좌표) {
                //현재 폭격 미사일의 시작 좌표가 현재요격가능한최대x좌표 보다 크거나 같은 경우에는

                요격미사일수 += 1; // 요격 미사일을 추가로 발사
                현재요격가능한최대x좌표 = target[1]; // 현재요격가능한최대x좌표를 target[1]로 업데이트
            }
        }
        return 요격미사일수;
    }
}

